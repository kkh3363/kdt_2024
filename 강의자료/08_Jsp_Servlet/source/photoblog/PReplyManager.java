package myPortal.pblog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import myPortal.db.DBConnectionMgr;

public class PReplyManager {
	private DBConnectionMgr pool;
	
	public PReplyManager() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//PReply List
	public Vector<PReplyBean> listPReply(int num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<PReplyBean> vlist = new Vector<PReplyBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tblPReply where num=? order by rnum desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PReplyBean bean = new PReplyBean();
				bean.setRnum(rs.getInt(1));
				bean.setNum(rs.getInt(2));
				bean.setId(rs.getString(3));
				bean.setRdate(rs.getString(4));
				bean.setComment(rs.getString(5));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	public void deleteAllPReply(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "delete from tblPReply where num=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
}
