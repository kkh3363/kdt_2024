package model;

public class testDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDaoMysql mdao = new MemberDaoMysql();
		MemberDTO member = new MemberDTO("winter", "겨울", "1234","겨울이");
		System.out.println( mdao.insertMember(member) ); 
	}

}
