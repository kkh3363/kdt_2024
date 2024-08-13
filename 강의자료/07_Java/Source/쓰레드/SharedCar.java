package sec04;

import java.util.Random;

public class SharedCar {
	public synchronized void drive(String name, String where) {
		System.out.println(name + "님이 자동차에 탔습니다.");
		Random r = new Random();
		for (int i = 0; i < r.nextInt(3) + 1; i++)
			System.out.println(name + "님이 자동차를 운전합니다.");
		System.out.println(name + "님이 " + where + "에 도착했습니다.");
	}
}