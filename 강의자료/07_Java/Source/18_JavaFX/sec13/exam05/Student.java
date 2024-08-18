package sec13.exam05;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
	private SimpleStringProperty name;
	private SimpleIntegerProperty korean;
	private SimpleIntegerProperty math;
	private SimpleIntegerProperty english;
	
	public Student() {
		this.name = new SimpleStringProperty();
		this.korean = new SimpleIntegerProperty();
		this.math = new SimpleIntegerProperty();
		this.english = new SimpleIntegerProperty();
	}
	public Student(String name, int korean, int math, int english) {
		this.name = new SimpleStringProperty(name);
		this.korean = new SimpleIntegerProperty(korean);
		this.math = new SimpleIntegerProperty(math);
		this.english = new SimpleIntegerProperty(english);
	}
	
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public int getKorean() {
		return korean.get();
	}
	public void setKorean(int korean) {
		this.korean.set(korean);;
	}
	public int getMath() {
		return math.get();
	}
	public void setMath(int math) {
		this.math.set(math);;
	}
	public int getEnglish() {
		return english.get();
	}
	public void setEnglish(int english) {
		this.english.set(english);
	}
}
