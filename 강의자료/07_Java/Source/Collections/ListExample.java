package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ArrayListExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");
		
		int size = list.size();
		System.out.println("총 객체수: " + size);		
		System.out.println();
		
		String skill = list.get(2);
		System.out.println("2: " + skill);
		System.out.println();
		
		for(int i=0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		// List foreach
		// 1. Consumer 사용 출력.....
		Consumer<String> consumer = x -> System.out.println("list Data => " + x);
		list.forEach(consumer);
		
		// 2. 
		//list.forEach(x -> System.out.println("list Data => " + x));
		showList(list);
		
		
	}
	public static <T> void showList(List<T> list) {
		list.forEach(x -> System.out.println("list Data => " + x));
	}
	
}
