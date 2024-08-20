package sec02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDemo {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost/javadb?serverTimezone=Asia/Seoul";

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("데이터베이스 연결중 ...");
			con = DriverManager.getConnection(url, "juser", "juser");
			System.out.println("데이터베이스 연결 성공");
			
			String sql = "" +
					"insert into users (userid, username, userpassword, userage,useremail) "+
					"values (?, ? , ? ,? ,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "january");
			pstmt.setString(2, "일월이");
			pstmt.setString(3, "1234");
			pstmt.setInt( 4, 20);
			pstmt.setString(5, "january@mycompany.com");
			
			//SQL문 실행 후
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수: " + rows);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾지 못했습니다...");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패");
            System.out.println(e.getMessage());
		}
		return con;
	}
	public static void main(String[] args) {
		makeConnection();
	}
}

