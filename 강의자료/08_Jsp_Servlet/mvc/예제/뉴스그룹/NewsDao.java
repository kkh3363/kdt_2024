package mymvc.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	// 리스트 가져오기....
	public List<News> getAll() throws Exception {
		List<News> newsList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "select aid, title, str_to_date(date,'%Y-%m-%d %h:%M:%s') as cdate from tblnews";
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
	//리스트 가져오기....
	public News getNews(int aid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		News newsBean = new News();
		
		try {
			con = pool.getConnection();
			sql = "select aid, title, img, str_to_date(date,'%Y-%m-%d %h:%M:%s') as cdate, content from tblnews where aid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, aid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				newsBean.setAid(rs.getInt("aid"));
				newsBean.setTitle(rs.getString("title"));
				newsBean.setImg(rs.getString("img"));
				newsBean.setDate(rs.getString("cdate"));
				newsBean.setContent(rs.getString("content"));
			}
		}catch (Exception e) {
				e.printStackTrace();
		} finally {
				pool.freeConnection(con, pstmt, rs);
		}
		return newsBean;
	}
	
	//
	public void addNews(News n) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "insert into tblnews(title,img,date,content) values(?,?,now(),?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, n.getTitle());
			pstmt.setString(2, n.getImg());
			pstmt.setString(3, n.getContent());
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	}
	//
	public void delNews(int aid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			con = pool.getConnection();
		
			sql = "delete from tblnews where aid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, aid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	}
	//
}
