package myPortal.photo;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpServletRequest;
import myPortal.bbs.FileManager;
import myPortal.db.DBConnectionMgr;

public class PMemberManager {
	private DBConnectionMgr pool;
	private static final String  SAVEFOLDER = "D:\\kdt2024\\WorkSpace\\JspWork\\myPortal\\src\\main\\webapp\\photo_files";
	
	public PMemberManager() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// member 추가하기
	public boolean insertPMember(HttpServletRequest req) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String profile = null;
		
		try {
			File file = new File(SAVEFOLDER);
			if (!file.exists())
				file.mkdirs();
			
			FileManager fMan = new FileManager();
			fMan.fileUpload(req, SAVEFOLDER);
			profile = fMan.fileName;
			
			con = pool.getConnection();
			sql = "insert tblPMember values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, req.getParameter("id"));
			pstmt.setString(2, req.getParameter("pwd"));
			pstmt.setString(3, req.getParameter("name"));
			pstmt.setString(4, profile);
			if(pstmt.executeUpdate()==1) 
				flag = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}
	// PMember Login
		public boolean loginPMember(String id, String pwd) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "select id from tblPMember where id=? and pwd=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery();
				flag = rs.next();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return flag;
		}

		// PMember Get
		public PMemberBean getPMember(String id) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			PMemberBean bean = new PMemberBean();
			try {
				con = pool.getConnection();
				sql = "select name, pwd ,profile from tblPMember where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bean.setId(id);
					bean.setName(rs.getString(1));
					bean.setPwd(rs.getString(2));
					bean.setProfile(rs.getString(3));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;
		}
}
