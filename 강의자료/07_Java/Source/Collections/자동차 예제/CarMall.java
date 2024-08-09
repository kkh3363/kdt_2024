package chap13.exam_car;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class CarMall {
	LinkedList<Car> cars;

	public CarMall() {
		cars = new LinkedList<Car>();
	}

	public void initData() {
		List<String> list = Arrays.asList("카니발,기아,2020,100000", "코란도,kgm,2023,40000"
				, "그랜져,현대,2021, 60000","싼타페,현대,2021,40000","아반테,현대,2019, 120000", "QM6,르노,2022,75000");

		Iterator<String> iterator = list.iterator();
		while( iterator.hasNext()) {
			String str = iterator.next();
			StringTokenizer st = new StringTokenizer(str,",");
			Car newCar = new Car();
			newCar.setModel(st.nextToken().trim());
			newCar.setMadeCompany(st.nextToken().trim());
			newCar.setGenYear(Integer.parseInt(st.nextToken().trim()));
			newCar.setMileage(Integer.parseInt(st.nextToken().trim()));
			
			cars.add(newCar);
		}
	}
	public <E> void showList(List<E> e) {
		for( E c : e) {
			System.out.print (c.toString() + " ");
		}
		System.out.println();
	}
	
	// 제조사 별로.....
	public void sortCar(String strMode) {
		LinkedList<Car> sortList = new LinkedList<>(cars);
		Comparator<Car> comparater;
		
		strMode = strMode.toUpperCase();
		
		switch ( strMode ) {
			case "MODEL" : comparater= Comparator.comparing(Car::getModel);break;
			case "MADE_COMMPANY" : comparater= Comparator.comparing(Car::getMadeCompany);break;
			case "GENYEAR" : comparater= Comparator.comparing(Car::getGenYear);break;
			case "MILEAGE" : comparater= Comparator.comparing(Car::getMileage);break;
			default :
				return;
		}
				
		
		System.out.println("Befor Sort");
		showList(sortList);
		Collections.sort(sortList, comparater);
		showList(sortList);
		
	}
	
}
