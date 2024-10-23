package myPortal.pblog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

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
	// pMember Get
	public PMemberBean getPMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		PMemberBean bean = new PMemberBean();
		try {
			con = pool.getConnection();
			sql = "select name,profile from tblPMember where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setId(id);
				bean.setName(rs.getString(1));
				bean.setProfile(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	// Random PMember List - 본인을 제외한 5명 리스트
	public Vector<PMemberBean> listPMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<PMemberBean> vlist = new Vector<PMemberBean>();
		try {
			con = pool.getConnection();
			sql = "select id,name,profile from tblPMember where id !=? order by rand() limit 5";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PMemberBean bean = new PMemberBean();
				bean.setId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setProfile(rs.getString(3));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
}
