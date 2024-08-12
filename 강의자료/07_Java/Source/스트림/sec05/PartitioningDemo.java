package sec05;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningDemo {
    public static void main(String[] args) {
        Stream<Nation> sn = Nation.nations.stream().limit(4);
        Map<Boolean, List<Nation>> m1 = sn
                .collect(Collectors.partitioningBy
                        (p -> p.getType() == Nation.Type.LAND));
        System.out.println(m1);

        sn = Nation.nations.stream().limit(4);
        Map<Boolean, Long> m2 = sn
                .collect(Collectors.partitioningBy(
                        p -> p.getType() == Nation.Type.LAND,
                        Collectors.counting()));
        System.out.println(m2);

        sn = Nation.nations.stream().limit(4);
        Map<Boolean, String> m3 = sn
                .collect(Collectors.partitioningBy(
                        p -> p.getType() == Nation.Type.LAND,
                        Collectors.mapping(Nation::getName,
                                Collectors.joining("#"))));
        System.out.println(m3);
    }
}