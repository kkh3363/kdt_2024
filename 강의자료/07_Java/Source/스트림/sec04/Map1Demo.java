package sec04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Map1Demo {
    public static void main(String[] args) {
        Stream<String> s1 = Stream.of("a1", "b1", "b2", "c1", "c2");

        Stream<String> s2 = s1.map(String::toUpperCase);
        s2.forEach(Util::print);
        System.out.println();

        Stream<Integer> i1 = Stream.of(1, 2, 1, 3, 3, 2, 4);

        Stream<Integer> i2 = i1.map(i -> i * 2);
        i2.forEach(Util::print);
        System.out.println();

        Stream<String> s3 = Stream.of("a1", "a2", "a3");

        Stream<String> s4 = s3.map(s -> s.substring(1));

        IntStream i3 = s4.mapToInt(Integer::parseInt);

        Stream<String> s5 = i3.mapToObj(i -> "b" + i);

        s5.forEach(Util::print);
    }
}