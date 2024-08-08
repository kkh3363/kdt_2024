package sec03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Comparator1Demo {
    public static void main(String[] args) {
        List<Car> list = Car.cars.subList(0, 3);
        Car[] cars = list.toArray(new Car[3]);

        Comparator<Car> modelComparator
                = Comparator.comparing(Car::getModel);

        System.out.println(Arrays.toString(cars));
        Arrays.sort(cars, modelComparator);
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, modelComparator.reversed());
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, Comparator.comparingInt(Car::getMileage));
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars, Comparator.comparing(Car::getMileage, (a, b) -> b - a));
        System.out.println(Arrays.toString(cars));
    }
}
