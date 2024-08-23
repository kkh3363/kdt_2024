package model;

import java.util.List;

public interface MemberDao {
	public int deleteMember(String userid);
	public int updateMember(MemberDTO memberDto);
	public int insertMember(MemberDTO memberDto);
	public int insertMember(String userid,String username,String userpasswd ,String tnickname);
	public MemberDTO getMemberOne(String userid);
	public void getMemberList();
}
