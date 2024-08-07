package generic_package;

import java.util.ArrayList;

public class GenericDemo_1 {

	public static void main(String[] args) {
		Cup<Beverage> bev = new Cup<>();
		Cup<Beer> beer = new Cup<>();
		
		bev.setBeverage(new Beer());
		bev.setBeverage(new Boricha());
		
		beer.setBeverage(new Beer());
		//beer.setBeverage(new Boricha()); X
		
		ArrayList<Beverage> list = new ArrayList<>();
		
		list.add(new Beverage());
		list.add(new Beer());
		list.add(new Boricha());
		beverageTest(list);
		
		ArrayList<Beer> list2 = new ArrayList<>();
		list2.add(new Beer());
		// list2.add(new Beverage()); X
		// list2.add(new Boricha()); X
		// beverageTest(list2); X
	}
	public static void beverageTest(ArrayList<Beverage> list) {}

}
