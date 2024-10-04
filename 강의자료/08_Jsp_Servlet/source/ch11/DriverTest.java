import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTest {

	public static void main(String[] args) {
		Connection con=null;
		String url = "jdbc:mysql://localhost/jspdb?serverTimezone=Asia/Seoul";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, "jspuser", "12345678");
			System.out.println("Success");
		}
		catch(SQLException ex){ 
			System.out.println("SQLException" + ex);
		}
		catch(Exception ex){ 
			System.out.println("Exception:" + ex);
		}
	}

}
