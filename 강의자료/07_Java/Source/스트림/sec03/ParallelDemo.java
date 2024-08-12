package sec03;

import java.util.stream.IntStream;

public class ParallelDemo {
    public static void main(String[] args) {
        long start, end, total;

        IntStream sequantial = IntStream.rangeClosed(1, 100000000);
        start = System.currentTimeMillis();
        total = sequantial.sum();
        end = System.currentTimeMillis();
        System.out.println("순차 처리 : " + (end - start));

        IntStream parallel = IntStream.rangeClosed(1, 100000000).parallel();
        start = System.currentTimeMillis();
        total = parallel.sum();
        end = System.currentTimeMillis();
        System.out.println("병렬 처리 : " + (end - start));
    }
}
