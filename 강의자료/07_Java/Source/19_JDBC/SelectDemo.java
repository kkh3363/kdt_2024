package sec02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDemo {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost/javadb?serverTimezone=Asia/Seoul";

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("데이터베이스 연결중 ...");
			con = DriverManager.getConnection(url, "juser", "juser");
			System.out.println("데이터베이스 연결 성공");
			
			String sql = "" +
					"SELECT userid, username, userpassword, userage, useremail " +
					"FROM users " +
					"WHERE userid=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "winter");
			
			//SQL문 실행 후, ResultSet을 통해 데이터 읽기
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("user name = "+ rs.getString("username"));
			}else {                           //데이터 행을 가져오지 않았을 경우
				System.out.println("사용자 아이디가 존재하지 않음");
			}
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
