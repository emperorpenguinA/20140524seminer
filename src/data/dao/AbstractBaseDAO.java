package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractBaseDAO {

    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/seminer";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "postgres";

    protected Connection conn = null;
    protected Statement stmt = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;

    public AbstractBaseDAO() {
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
