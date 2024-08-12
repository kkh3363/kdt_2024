package sec04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FilterDemo {
    public static void main(String[] args) {
        Stream<String> s1 = Stream.of("a1", "b1", "b2", "c1", "c2", "c3");
        Stream<String> s2 = s1.filter(s -> s.startsWith("c"));
        Stream<String> s3 = s2.skip(1);
        System.out.print("문자열 스트림 : ");
        s3.forEach(Util::print);

        IntStream i1 = IntStream.of(1, 2, 1, 3, 3, 2, 4);
        IntStream i2 = i1.filter(i -> i % 2 == 0);
        IntStream i3 = i2.distinct();
        System.out.print("\n정수 스트림 : ");
        i3.forEach(Util::print);

        System.out.print("\n인구가 1억(100백만) 이상의 2개 나라 : ");
        Stream<Nation> n1 = Nation.nations.stream();
        Stream<Nation> n2 = n1.filter(p -> p.getPopulation() > 100.0);
        Stream<Nation> n3 = n2.limit(2);
        n3.forEach(Util::printWithParenthesis);
    }
}