package ankrutik.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamsBasics {
    public static void main(String[] args) {
        List<Double> temperatures = Arrays.asList(100.2, 98.0, 67.5, 103.4);
        System.out.println("Count is:" +
                temperatures.stream()           // SOURCE
                .peek(System.out::println)      // INTERMEDIATE OP
                .filter(t -> t > 100)    // INTERMEDIATE OP
                .peek(System.out::println)      // INTERMEDIATE OP
                .count())                       // TERMINAL         printHeader("AnyMatch 2");

        ;

        printHeader("ForEach");
        Stream.of("Alex", "Ben", "Charlie", "Subko", "Corridor7")
                .filter(s -> {
                    System.out.println("Filter1: "+s);
                    return true;
                })
                .forEach(s -> System.out.println(s));
                ;

        printHeader("AnyMatch 2");
        Stream.of("Alex", "Ben", "Charlie", "Subko", "Corridor7")
                .map(s -> {
                    System.out.println("Filter1: "+s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("Terminal: "+s);
                    return s.startsWith("C");
                });

        printHeader("Limit");
        Stream.of("Alex", "Ben", "Charlie", "Subko", "Corridor7", "Sartre", "Standart")
                .filter(s -> {
                    return s.length() > 3;
                })
                .filter(s -> {
                    return s.contains("S");
                })
                .peek(System.out::println)
                .sorted()
                .limit(2)
                .forEach(System.out::println)
        ;

        printHeader("Map and collection view");
        Map<String, Integer> nameAge = new HashMap<>();
        nameAge.put("Krutik", 35);
        nameAge.put("Pratiksha", 32);
        nameAge.put("Cat", 5);
        System.out.println(nameAge.entrySet().stream()
                .peek(System.out::println) // prints nothing
                .count());
    }

    static void printHeader(String content){
        System.out.println("\n============\n" + content + "\n============\n");
    }
}
