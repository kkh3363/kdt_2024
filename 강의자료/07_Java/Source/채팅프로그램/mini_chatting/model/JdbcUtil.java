package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	private static final  String driver = "com.mysql.cj.jdbc.Driver";
	private static final String db_hostname = "localhost";
    private static final int db_portnumber = 3306;
    private static final String db_database = "javadb";
    private static final String db_charset = "utf8";
    private static final String db_username = "juser";
    private static final String db_password = "juser";
    
	private static Connection connect;
	
	public static Connection getConnection() {
		if ( connect == null) {
			String urlFormat = "jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=Asia/Seoul";
			String url = String.format(urlFormat, db_hostname, db_portnumber, db_database, db_charset);
			try {
				 Class.forName(driver);
				 connect = DriverManager.getConnection(url, db_username, db_password);
				// System.out.println(url);
			} catch (ClassNotFoundException e) {
				System.out.println("==== DATABASE Connect Fail ===");
                System.out.println(e.getMessage());
			}catch (SQLException e) {
                System.out.println("=== DATABASE Fail ===");
                System.out.println(e.getMessage());
            }
		}	
		return connect;
	}
	public void close() {
        if(connect != null) {
            /** 데이터베이스 접속 해체 처리 */
            try {
            	connect.close();
            } catch (Exception e) {
                System.out.println("=== DATABASE Disconnect Fail ===");
                System.out.println(e.getMessage());
            }
            connect = null;
        }
    }
}
