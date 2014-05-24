package data.dao;

import java.sql.SQLException;
import java.sql.Timestamp;

import data.dao.entity.Comment;

public class CommentDao extends AbstractBaseDAO {

    private static final String INSERT_SQL = "INSERT INTO test.\"comment\"(\"userId\", \"messageId\", content, \"insertTime\", \"updateTime\") VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_SQL = "SELECT * FROM test.\"comment\"";
    private static final String UPDATE_SQL = "UPDATE test.\"comment\"";

    public void insert(final Comment comment) {
        try {
            pstmt = conn.prepareStatement(INSERT_SQL);
            pstmt.setInt(1, comment.getUserId());
            pstmt.setInt(2, comment.getMessageId());
            pstmt.setString(3, comment.getContent());
            Timestamp now = new Timestamp(System.currentTimeMillis());
            pstmt.setTimestamp(4, now);
            pstmt.setTimestamp(5, now);
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
    public Comment selectByPrimaryKey(final Integer commentId) {

        try {
            StringBuilder sqlSb = new StringBuilder(SELECT_SQL);
            sqlSb.append("where \"messageId\" = ?");
            pstmt = conn.prepareStatement(sqlSb.toString());
            pstmt.setInt(1, commentId);
            rs = pstmt.executeQuery();
            Comment message = new Comment();
            while (rs.next()) {
                message.setCommentId(rs.getInt("commentId"));
                message.setUserId(rs.getInt("userId"));
                message.setMessageId(rs.getInt("messageId"));
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
}
