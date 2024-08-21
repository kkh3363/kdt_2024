package json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;



public class jsonParsingDemo {

	public static void main(String[] args) throws IOException {
		String fName = "src/json/member.json";
		BufferedReader br = new BufferedReader(new FileReader(fName, Charset.forName("UTF-8")));
		
		String inJson = br.readLine();
		br.close();
		
		//JSON 파싱
		JSONObject root = new JSONObject(inJson);
		//속성 정보 읽기
		System.out.println("id: " + root.getString("id"));
		System.out.println("name: " + root.getString("name"));
		System.out.println("age: " + root.getInt("age"));
		System.out.println("student: " + root.getBoolean("student"));
		
		//객체 속성 정보 읽기
		JSONObject tel = root.getJSONObject("tel");
		System.out.println("home: " + tel.getString("home"));
		System.out.println("mobile: " + tel.getString("mobile"));
		
		JSONArray skill = root.getJSONArray("skill");
		System.out.print("skill: ");
		for(int i=0; i<skill.length(); i++) {
			System.out.print(skill.get(i) + ", ");
		}
		
	}

}
