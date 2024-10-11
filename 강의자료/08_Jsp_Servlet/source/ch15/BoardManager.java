package myPortal.bbs;

import java.sql.*;
import java.util.Vector;

import jakarta.servlet.http.HttpServletRequest;
import myPortal.db.DBConnectionMgr;

public class BoardManager {
	private DBConnectionMgr pool;
	
	public BoardManager() {
		try {
			pool = DBConnectionMgr.getInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 게시판 리스트 
	public Vector<BoardBean> getBoardList(String keyField, String keyWord, int start, int end){
		Vector<BoardBean> vlist = new Vector<BoardBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			if ( keyWord.equals("null") || keyWord.equals("") ) {
				sql = "select * from tblBoard order by ref desc, pos limit ?, ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else {
				sql = "select * from  tblBoard where " + keyField + " like ? ";
				sql += "order by ref desc, pos limit ? , ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + keyWord + "%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardBean bean = new BoardBean();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSubject(rs.getString("subject"));
				bean.setPos(rs.getInt("pos"));
				bean.setRef(rs.getInt("ref"));
				bean.setDepth(rs.getInt("depth"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setCount(rs.getInt("count"));
				vlist.add(bean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return vlist;
	} // getBoardList()
	
	// 총 게시물수...
	public int getTotalCount(String keyField, String keyWord) {
		int totalCount= 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = pool.getConnection();
			if (keyWord.equals("null") || keyWord.equals("")) {
				sql = "select count(num) from tblBoard";
				pstmt = con.prepareStatement(sql);
			} else {
				sql = "select count(num) from  tblBoard where " + keyField + " like ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + keyWord + "%");
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return totalCount;
	} //getTotalCount
	
	public int upCount(int num) {
		int  nCount= -1;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "update tblBoard set count=count+1 where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			nCount= pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return nCount;
	} // upCount;
	
	public BoardBean getBoard(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BoardBean bean = new BoardBean();
		try {
			con = pool.getConnection();
			sql = "select * from tblBoard where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSubject(rs.getString("subject"));
				bean.setContent(rs.getString("content"));
				bean.setPos(rs.getInt("pos"));
				bean.setRef(rs.getInt("ref"));
				bean.setDepth(rs.getInt("depth"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setPass(rs.getString("pass"));
				bean.setCount(rs.getInt("count"));
				bean.setFilename(rs.getString("filename"));
				bean.setFilesize(rs.getInt("filesize"));
				bean.setIp(rs.getString("ip"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}// getBoard()
	
	// 게시물을 db에 저장하자.... 
	public void insertBoard(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String filename="";
		int filesize=0;
		String content="";
		try {
			con = pool.getConnection();
			sql = "select max(num) from tblBoard";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int ref = 1;
			if (rs.next())
				ref = rs.getInt(1) + 1;
			
			content = req.getParameter("content");
			if ( req.getParameter("contentType").equalsIgnoreCase("TEXT") ) {
				content = UtilMgr.replace(content, "<", "&lt;");
			}
			sql = "insert tblBoard(name,content,subject,ref,pos,depth,regdate,pass,count,ip,filename,filesize)";
			sql += "values(?, ?, ?, ?, 0, 0, now(), ?, 0, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, req.getParameter("name"));
			pstmt.setString(2, content);
			pstmt.setString(3, req.getParameter("subject"));
			pstmt.setInt(4, ref);
			pstmt.setString(5, req.getParameter("pass"));
			pstmt.setString(6, req.getParameter("ip"));
			pstmt.setString(7, filename);
			pstmt.setInt(8, filesize);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	} // insertBoard
} // End of Class














