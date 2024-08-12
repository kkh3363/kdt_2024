package sec04;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatchDemo {
    public static void main(String[] args) {
        boolean b1 = Stream.of("a1", "b2", "c3").anyMatch(s -> s.startsWith("c"));
        System.out.println(b1);

        boolean b2 = IntStream.of(10, 20, 30).allMatch(p -> p % 3 == 0);
        System.out.println(b2);

        boolean b3 = IntStream.of(1, 2, 3).noneMatch(p -> p == 3);
        System.out.println(b3);

        if (Nation.nations.stream().allMatch(d -> d.getPopulation() > 100.0))
            System.out.println("모든 국가의 인구가 1억이 넘는다.");
        else
            System.out.println("모든 국가의 인구가 1억이 넘지 않는다.");

        Optional<Nation> nation = Nation.nations.stream().findFirst();
        nation.ifPresentOrElse(Util::print, () -> System.out.print("없음."));
        System.out.println();

        nation = Nation.nations.stream().filter(Nation::isIsland).findAny();
        nation.ifPresent(Util::print);
    }
}