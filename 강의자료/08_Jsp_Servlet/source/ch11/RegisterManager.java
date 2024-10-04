package ch11;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class RegisterManager {
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
 	private final String JDBC_URL = "jdbc:mysql://localhost/jspdb?serverTimezone=Asia/Seoul";
 	private final String USER = "jspuser";
 	private final String PASS = "12345678";
 	
 	public RegisterManager() {
 		try {
 			Class.forName(JDBC_DRIVER);
 		}catch(Exception e){
 	 	      System.out.println("Error : JDBC 드라이버 로딩 실패");
  	   }
 	}
 	public Vector<RegisterBean> getRegisterList(){
 		Connection conn = null;
 		Statement stmt = null;
        ResultSet rs = null;
        Vector<RegisterBean> vlist = new Vector<RegisterBean>();
        try {
        	conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
        	 String strQuery = "select * from tblRegister";
        	 stmt = conn.createStatement();
             rs = stmt.executeQuery(strQuery);
             while(rs.next()){
            	 RegisterBean bean = new RegisterBean();
            	 bean.setId (rs.getString("id"));
            	 bean.setPwd (rs.getString("pwd"));
     			 bean.setName (rs.getString("name"));
     			 bean.setNum1 (rs.getString("num1"));
     			 bean.setNum2 (rs.getString("num2"));
     			 bean.setEmail (rs.getString("email"));
     			 bean.setPhone (rs.getString("phone"));
     			 bean.setZipcode (rs.getString("zipcode"));
     			 bean.setAddress (rs.getString("address"));
     			 bean.setJob (rs.getString("job"));
     			 
     			vlist.addElement(bean);
             }
        } catch(Exception ex) {
            System.out.println("Exception" + ex);
        } finally {
        	if(rs!=null)   try{rs.close();}  catch(SQLException e){}
  		  	if(stmt!=null) try{stmt.close();}catch(SQLException e){}
  		  	if(conn!=null) try{conn.close();}catch(SQLException e){}
        }
        
        return vlist;
 	}
}
