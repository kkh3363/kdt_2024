import java.text.*;
import java.util.*;

public class MessageFormatDemo {

	public static void main(String[] args) {
		String java = "Java";
		int version = 8;
		
		String s = MessageFormat.format("language : {1}\nversion: {0}", version, java );
				
		System.out.println( java + " version = " + version);
		
		
		System.out.println(s );
		version = 9;
		
		s = MessageFormat.format("version: {0} \nlanguage : {1}", version, java );
		System.out.println(s );
		
		String name ="홍길동";
		String sex = "남자";
		String age = "39";
		
		String text1 = "나의 이름은 "+name+" 입니다. 성별은 "+sex+"이고 나이는 "+age+"입니다.";
		System.out.println(text1);
		
		String text2 = MessageFormat.format("나의 이름은 {0} 입니다. 성별은 {1}이고 나이는 {2}입니다."
				, name, sex, age);
		System.out.println(text2);
		
		Object[] objects = new Object[]{"빨강", "초록", "파랑"};
		String colors = MessageFormat.format("빛의 삼원색은 {0}, {1}, {2} 이다.", objects);		
		System.out.println(colors);
		
		String printDate = MessageFormat.format("오늘 날짜는  {0, date} 입니다.", new Date());
		String printTime = MessageFormat.format("현재 시간은 \"{0, time}\" 입니다.", new Date());
		System.out.println(printDate);
		System.out.println(printTime);

	}

}

