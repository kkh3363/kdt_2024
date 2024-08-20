package daoex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static DBManager current = null;
	
	public static DBManager getInstance() {
        if (current == null) {
            current = new DBManager();    
        }
        return current;
    }

    public static void freeInstance() {
        current = null;
    }
    private DBManager() {
        super();
    }
    
    private static final String db_hostname = "localhost";
    private static final int db_portnumber = 3306;
    private static final String db_database = "javadb";
    private static final String db_charset = "utf8";
    private static final String db_username = "juser";
    private static final String db_password = "juser";
    
    private Connection conn = null;
    
    public Connection open() {
        if (conn == null) {
        	String urlFormat = "jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=Asia/Seoul";
            String url = String.format(urlFormat, db_hostname, db_portnumber, db_database, db_charset);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                conn = DriverManager.getConnection(url, db_username, db_password);
                System.out.println("=== DATABASE Connect Success ===");
            } catch (ClassNotFoundException e) {
                // 실패시 메시지와 에러 내용 출력
                System.out.println("==== DATABASE Connect Fail ===");
                System.out.println(e.getMessage());
            }

            catch (SQLException e) {
                System.out.println("=== DATABASE Connect Fail ===");
                System.out.println(e.getMessage());
            }
        }
        return conn;
    }
    public void close() {
        if(conn != null) {
            /** 데이터베이스 접속 해체 처리 */
            try {
                conn.close();
                System.out.println("=== DATABASE Disconnect Success ===");
            } catch (Exception e) {
                System.out.println("=== DATABASE Disconnect Fail ===");
                System.out.println(e.getMessage());
            }
            conn = null;
        }
    }
}
