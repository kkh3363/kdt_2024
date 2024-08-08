package sec03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Operator2Demo {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (a, b) -> a - b;

        BinaryOperator<Integer> o1 = BinaryOperator.maxBy(comparator);
        System.out.println(o1.apply(10, 5));
        System.out.println(o1.apply(20, 25));

        BinaryOperator<Integer> o2 = BinaryOperator.minBy(comparator);
        System.out.println(o2.apply(10, 5));
        System.out.println(o2.apply(20, 25));

        List<Car> newCars = remodeling(Car.cars, c -> new Car("뉴" +
                c.getModel(), c.isGasoline(), c.getAge(), c.getMileage()));
        System.out.println(newCars);
    }

    static public List<Car> remodeling(List<Car> cars, UnaryOperator<Car> o) {
        List<Car> result = new ArrayList<>();
        for (Car car : Car.cars)
            result.add(o.apply(car));
        return  result;
    }
}
