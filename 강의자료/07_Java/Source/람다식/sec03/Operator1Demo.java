package sec03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class Operator1Demo {
    public static void main(String[] args) {
        IntUnaryOperator add2 = x -> x + 2;
        System.out.println(add2.applyAsInt(3));

        UnaryOperator<Integer> add2again = x -> x + 2;
        System.out.println(add2again.apply(3));

        IntUnaryOperator mul2 = x -> x * 2;
        IntUnaryOperator add2mul2 = add2.andThen(mul2);
        System.out.printf("(3 + 2) * 2 = ");
        System.out.println(add2mul2.applyAsInt(3));

        IntBinaryOperator add = (x, y) -> x + y;
        System.out.println(add.applyAsInt(1, 2));

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.replaceAll(e -> e + 10);
        System.out.println(list);
    }
}
