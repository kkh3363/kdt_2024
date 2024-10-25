package mymvc.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {
	private DBConnectionMgr pool;
	public NewsDao() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<News> getAll() throws Exception {
		List<News> newsList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = "select aid, title, PARSEDATETIME(date,'yyyy-MM-dd hh:mm:ss') as cdate from tblnews";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next() ){
				News n = new News();
				n.setAid(rs.getInt("aid"));
				n.setTitle(rs.getString("title"));
				n.setDate(rs.getString("cdate")); 
				
				newsList.add(n);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return newsList;
	}
}
