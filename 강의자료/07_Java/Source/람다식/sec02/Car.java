package sec02;

import java.util.Arrays;
import java.util.List;

public class Car {
    private String model;
    private boolean gasoline;
    private int age;
    private int mileage;

    public Car(String model, boolean gasoline, int age, int mileage) {
        this.model = model;
        this.gasoline = gasoline;
        this.age = age;
        this.mileage = mileage;
    }

    public String getModel() {
        return model;
    }

    public boolean isGasoline() {
        return gasoline;
    }

    public int getAge() {
        return age;
    }

    public int getMileage() {
        return mileage;
    }

    public String toString() {
        return String.format("Car(%s, %s, %d, %d)", model, gasoline, age, mileage);
    }

    public static final List<Car> cars = Arrays.asList(
            new Car("소나타", true, 18, 210000),
            new Car("코란도", false, 15, 200000),
            new Car("그랜저", true, 12, 150000),
            new Car("싼타페", false, 10, 220000),
            new Car("아반테", true, 10, 70000),
            new Car("에쿠스", true, 6, 100000),
            new Car("그랜저", true, 5, 80000),
            new Car("소나타", true, 2, 35000),
            new Car("쏘렌토", false, 1, 10000),
            new Car("아반테", true, 1, 7000));
}