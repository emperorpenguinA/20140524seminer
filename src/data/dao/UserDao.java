package data.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dao.entity.User;

public class UserDao extends AbstractBaseDAO {

    private static final String INSERT_SQL = "INSERT INTO user (password, account, name, age, gender, hometown, \"insertTime\", \"updateTime\") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_SQL = "SELECT * FROM test.\"user\" ";
    private static final String UPDATE_SQL = "UPDATE user ";

    /**
     *  primarykeyで1件取得
     * @param userId
     * @return
     */
    public User selectByPrimaryKey(final Integer userId) {

        try {
            StringBuilder sqlSb = new StringBuilder(SELECT_SQL);
            sqlSb.append("where \"userId\" = ?");
            pstmt = conn.prepareStatement(sqlSb.toString());
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            User user = new User();
            while (rs.next()) {
                user.setUserId(rs.getInt("userId"));
                user.setPassword(rs.getString("password"));
                user.setAccount(rs.getString("account"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setHometown(rs.getString("hometown"));
                user.setInsertTime(rs.getTimestamp("insertTime"));
                user.setUpdateTime(rs.getTimestamp("updateTime"));
            }
            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            disconnect();
        }
        return null;
    }

    /**
     * accountとpasswordで1件取得
     * @return
     */
    public User selectByAccountAndPassword(final String account, final String password) {

        try {
            StringBuilder sqlSb = new StringBuilder(SELECT_SQL);
            sqlSb.append("where account = ? and password = ?");
            pstmt = conn.prepareStatement(sqlSb.toString());
            pstmt.setString(1, account);
            pstmt.setString(1, password);
            rs = pstmt.executeQuery();
            List<User> userList = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setPassword(rs.getString("password"));
                user.setAccount(rs.getString("account"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setHometown(rs.getString("hometown"));
                user.setInsertTime(rs.getTimestamp("insertTime"));
                user.setUpdateTime(rs.getTimestamp("updateTime"));
                userList.add(user);
            }
            if (userList.size() == 0) {
                new SQLException("対象がない");
            } else if (userList.size() > 1) {
                new SQLException("対象に以上あり");
            }

            return userList.get(0);
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            disconnect();
        }
        return null;
    }
}
