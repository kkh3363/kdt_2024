package json;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;



public class JsonDemo {

	public static void main(String[] args) throws IOException {
		JSONObject root = new JSONObject();
		//속성 추가
		root.put("id", "winter");
		root.put("name", "한겨울");
		root.put("age", 25);
		root.put("student", true);

		JSONObject tel = new JSONObject();
		tel.put("home", "02-123-1234");
		tel.put("mobile", "010-123-1234");
		root.put("tel", tel);
		//배열 속성 추가
		JSONArray skill = new JSONArray();
		skill.put("java");
		skill.put("c");
		skill.put("c++");
		root.put("skill", skill);
		
		//JSON 얻기
		String jsonStr = root.toString();
		System.out.println(jsonStr);
		
		// 파일에 쓰기.....
		Writer writer = new FileWriter("src/json/member.json", Charset.forName("UTF-8"));
		writer.write(jsonStr);
		writer.flush();
		writer.close();
	}

}
