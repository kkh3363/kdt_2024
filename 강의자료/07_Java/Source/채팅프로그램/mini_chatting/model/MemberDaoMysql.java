package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoMysql implements MemberDao{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private List<MemberDTO> memberLists = null; 

	private final String MEMBER_LIST = "select * from member";
	private final String MEMBER_LIST_ONE = "select * from member where userid = ?";
	private final String MEMBER_INSERT = "insert into member values(?, ?, ?, ? )";
	private final String MEMBER_UPDATE = "update member set username = ? , userpassword= ? , nickname= ? where member_id = ?";
	private String MEMBER_DELETE = "delete member where userid = ?";
	
	public MemberDaoMysql() {
		//this.conn = conn;
		memberLists = new ArrayList<>();
	}
	
	@Override
	public int deleteMember(String userid) {
		int result = 0;
		pstmt = null;
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(MEMBER_DELETE);
			pstmt.setString(1, userid);
        	result = pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Update Fail : " + e.getMessage());
		}finally {
			if (pstmt != null) {
				try {	pstmt.close(); }
				catch (SQLException e) {}
			}
		}
		
		return result;
	}
	
	@Override
	public int updateMember(MemberDTO memberDto) {
		int result = 0;
		pstmt = null;
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(MEMBER_UPDATE);
			
			pstmt.setString(1, memberDto.getUsername() );
            pstmt.setString(2, memberDto.getUserpasswd());
            pstmt.setString(3, memberDto.getNickname());
            //pstmt.setString(3, memberDto.getTel());
            //pstmt.setString(4, memberDto.getUseremail());
            pstmt.setString(4, memberDto.getUserid());
            
        	result = pstmt.executeUpdate();
        	
		}catch(SQLException e) {
			System.out.println("Update Fail : " + e.getMessage());
		}finally {
			if (pstmt != null) {
				try {	pstmt.close(); }
				catch (SQLException e) {}
			}
		}
		
		return result;
	}
	@Override
	public int insertMember(String userid,String username,String userpasswd ,String tnickname) {
		MemberDTO member = new MemberDTO(userid, username, userpasswd,userpasswd);
		return insertMember(member);
	}
	@Override
	public int insertMember(MemberDTO memberDto) {
		int result = 0;
		pstmt = null;
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(MEMBER_INSERT);
			
			pstmt.setString(1, memberDto.getUserid());
			pstmt.setString(2, memberDto.getUsername() );
            pstmt.setString(3, memberDto.getUserpasswd());
            pstmt.setString(4, memberDto.getNickname());
            //pstmt.setString(4, memberDto.getTel());
            //pstmt.setString(5, memberDto.getUseremail());
            
        	result = pstmt.executeUpdate();
        	System.out.println("Insert result : " + result);
        	
		}catch(SQLException e) {
			System.out.println("insert Fail : " + e.getMessage());
		}finally {
			if (pstmt != null) {
				try {	pstmt.close(); }
				catch (SQLException e) {}
			}
		}
		return result;
	}
	@Override
	public MemberDTO getMemberOne(String userid) {
		MemberDTO member = null;
		rs = null;
		pstmt = null;
		conn = JdbcUtil.getConnection();
		
		if ( userid.length() < 1 || conn == null )
			return null;
		
		try {
			pstmt = conn.prepareStatement(MEMBER_LIST_ONE);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();
            if ( rs.next()) {
            	member = new MemberDTO();
            	member.setUserid(rs.getString("userid"));
            	member.setUsername(rs.getString("username") );
            	member.setUserpasswd(rs.getString("userpasswd"));
            	member.setNickname(rs.getString("nickname"));
            	//member.setTel(rs.getString("usertel");
            	//member.setUseremail(rs.getString("useremail");
            }
		}catch (SQLException e) {
			System.out.println("select : " + e.getMessage());
		}finally {
			if (pstmt != null) {
				try {	pstmt.close(); }
				catch (SQLException e) {}
			}
		}
		return member;
	}
	@Override
	public void getMemberList() {
		rs = null;
		pstmt = null;
		memberLists.clear();
		
		conn = JdbcUtil.getConnection();
		 
		if (conn == null )
			return ;
		try {
			pstmt = conn.prepareStatement(MEMBER_LIST );
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	String  userid = rs.getString("userid");
                String username = rs.getString("username");
                String userpasswd = rs.getString("userpasswd");
                String nickname = rs.getString("nickname");
                
                MemberDTO newMenber = new MemberDTO(userid, username, userpasswd, nickname);
                memberLists.add(newMenber);
            }
            
		}catch (SQLException e) {
			System.out.println("select : " + e.getMessage());
		}finally {
			if (pstmt != null) {
				try {	pstmt.close(); }
				catch (SQLException e) {}
			}
		}
	}
	
}

