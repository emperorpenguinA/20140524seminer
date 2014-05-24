package data.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import data.dao.entity.Message;

public class MessageDao extends AbstractBaseDAO {

    private static final String INSERT_SQL = "INSERT INTO test.\"message\"(\"userId\", content, \"insertTime\", \"updateTime\") VALUES (?, ?, ?, ?)";
    private static final String SELECT_SQL = "SELECT * FROM test.\"message\"";
    private static final String UPDATE_SQL = "UPDATE test.\"message\"";

    public void insert(final Message message) {
        try {
            pstmt = conn.prepareStatement(INSERT_SQL);
            pstmt.setInt(1, message.getUserId());
            pstmt.setString(2, message.getContent());
            Timestamp now = new Timestamp(System.currentTimeMillis());
            pstmt.setTimestamp(3, now);
            pstmt.setTimestamp(4, now);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            disconnect();
        }
    }

    /**
     *  primarykeyで1件取得
     * @param userId
     * @return
     */
    public Message selectByPrimaryKey(final Integer messageId) {

        try {
            StringBuilder sqlSb = new StringBuilder(SELECT_SQL);
            sqlSb.append("where \"messageId\" = ?");
            pstmt = conn.prepareStatement(sqlSb.toString());
            pstmt.setInt(1, messageId);
            rs = pstmt.executeQuery();
            Message message = new Message();
            while (rs.next()) {
                message.setMessageId(rs.getInt("messageId"));
                message.setUserId(rs.getInt("userId"));
                message.setContent(rs.getString("content"));
                message.setInsertTime(rs.getTimestamp("insertTime"));
                message.setUpdateTime(rs.getTimestamp("updateTime"));
            }
            return message;
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            disconnect();
        }
        return null;
    }

    /**
     * 最新の指定件数を取得
     * @return
     */
    public List<Message> selectByRecentRecord(final Integer limitNum) {

        try {
            StringBuilder sqlSb = new StringBuilder(SELECT_SQL);
            sqlSb.append("order by updateTime desc");
            sqlSb.append("limit ").append(limitNum);
            pstmt = conn.prepareStatement(sqlSb.toString());
            rs = pstmt.executeQuery();
            List<Message> messageList = new ArrayList<Message>();
            while (rs.next()) {
                Message message = new Message();
                message.setMessageId(rs.getInt("messageId"));
                message.setUserId(rs.getInt("userId"));
                message.setContent(rs.getString("content"));
                message.setInsertTime(rs.getTimestamp("insertTime"));
                message.setUpdateTime(rs.getTimestamp("updateTime"));
                messageList.add(message);
            }
            return messageList;
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            disconnect();
        }
        return null;
    }

}
