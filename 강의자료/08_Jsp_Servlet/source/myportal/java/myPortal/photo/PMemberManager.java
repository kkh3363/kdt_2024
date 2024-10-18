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
}
