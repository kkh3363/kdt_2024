package model;

public class MemberDTO {
	private String userid;
	private String username;
	private String userpasswd;
	private String nickname;
	//private String useremail;
	
	public MemberDTO() {}
	
	public MemberDTO(String userid,String username,String userpasswd ,String nickname) {
		this.userid = userid;
		this.username = username;
		this.userpasswd= userpasswd;
		this.nickname = nickname;
		//this.tel  = tel;
		//this.useremail = useremail;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUsername(String username) {
		this.username = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpasswd() {
		return userpasswd;
	}
	public void setUserpasswd(String userpasswd) {
		this.userpasswd = userpasswd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/*public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	*/
}
