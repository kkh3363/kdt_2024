package ch11;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class RegisterMgrPool {
	
	private DBConnectionMgr pool = null;
	
	public RegisterMgrPool() {
 	 try{
 	   pool = DBConnectionMgr.getInstance();
 	   }catch(Exception e){
 	      System.out.println("Error : 커넥션 얻어오기 실패");
 	   }
     }
 
    public Vector<RegisterBean> getRegisterList() {
	   Connection conn = null;
	   Statement stmt = null;
	   ResultSet rs = null;
	   Vector<RegisterBean> vlist = new Vector<RegisterBean>();	   
       try {
          conn = pool.getConnection();
          String strQuery = "select * from tblRegister";
          stmt = conn.createStatement();
          rs = stmt.executeQuery(strQuery);
		  while (rs.next()) {
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
       } catch (Exception ex) {
          System.out.println("Exception" + ex);
       } finally {
	      pool.freeConnection(conn);
       }
       return vlist;
    }
 }