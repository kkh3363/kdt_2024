package myPortal.pblog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import myPortal.db.DBConnectionMgr;

public class PBlogManager {
	private DBConnectionMgr pool;
	
	public PBlogManager() {
		try {
			pool = DBConnectionMgr.getInstance();
		}catch( Exception e) {
			e.printStackTrace();
		}
	}
	
	// 로그인 검사.....
	public boolean loginPMember(String id, String pwd ) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "select id from tblPMember where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			flag = rs.next();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
		
	}
}
