package myPortal.pblog;

public class PMemberBean {
	private String id;
	private String pwd;
	private String name;
	private String profile;
	
	public PMemberBean() {}
	public PMemberBean(String id,String pwd,String name,String profile ) {
		this.id = id;
		this.pwd = pwd;
		this.name=name;
		this.profile = profile;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
}
