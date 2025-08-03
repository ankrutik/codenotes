package ankrutik.streams.assignments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAssignments {
    public static void main(String[] args) {
        StreamAssignments assignments = new StreamAssignments();
        System.out.println(assignments.q1().orElse(-1));
        System.out.println(assignments.q2());
        assignments.q3();
    }

    OptionalDouble q1(){
        printHeader("q1");
        return IntStream.range(0, 5).average();
    }

    String q2(){
        printHeader("q2");
        record Item(Integer id, String name){};
        return Stream.of(new Item(1, "Screw"), new Item(2, "Nail"), new Item(3, "Bolt"))
                .sorted(Comparator.comparing(i -> i.name))
                .reduce("" , (a,b) -> a + b.name, (a, b) -> a + b)
                ;
    }

    void q3(){
        printHeader("q3");
        Stream<List<String>> listStream = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"));
        listStream.filter(l -> l.contains("c"))
                .flatMap(l -> l.stream())
                .forEach(System.out::println);
    }

    private static void printHeader(String x) {
        System.out.println("========\n"+x+"\n========");
    }
}
