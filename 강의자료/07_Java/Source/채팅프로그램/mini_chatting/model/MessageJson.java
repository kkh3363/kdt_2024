package model;

import org.json.JSONObject;

public class MessageJson {
	private static JSONObject jsonData = new JSONObject();
	
	public static String makeMemberDto(String command, MemberDTO member) {
		String str;
		jsonData.clear();
		
		jsonData.put("command", command);
		JSONObject mjson = new JSONObject();
		mjson.put("userid", member.getUserid());
		mjson.put("userpasswd", member.getUserpasswd());
		mjson.put("username", member.getUsername());
		mjson.put("nickname", member.getNickname());
		
		jsonData.put("member", mjson);
		str = jsonData.toString();
		return str;
	}
	public static String makeMessage(String msg) {
		String str;
		jsonData.clear();
		
		jsonData.put("command", "msg");
		jsonData.put("data", msg);
		str = jsonData.toString();
		return str;
	}
}

