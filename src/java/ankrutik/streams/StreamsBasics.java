package ankrutik.streams;

import java.util.*;
import java.util.stream.*;

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

        printHeader("Reduce 1 : Concatenate");
        Stream<String> stream1 =
                Stream.of("k", "r", "u", "t", "i", "k");
        System.out.println(stream1.reduce("", (v1, v2) -> v1 + v2));
        // krutik

        printHeader("Reduce 2 : Sum of all values");
        Stream<Integer> stream2 =
                Stream.of(1, 2, 3, 4);
        System.out.println(stream2.reduce(0, (v1, v2) -> v1 + v2));
        // 10

        printHeader("Reduce 3 : Optional with value");
        Stream<String> stream3 =
                Stream.of("k", "r", "u", "t", "i", "k");
        Optional<String> optional1 =
                stream3.reduce( (v1, v2) -> v1 + v2);
        System.out.println(optional1.isPresent() ? optional1.get() : "Not present in Optional");

        printHeader("Reduce 4 : Optional without value");
        Stream<String> stream4 =
                Stream.of(); // empty on purpose
        Optional<String> optional2 =
                stream4.reduce( (v1, v2) -> v1 + v2);
        System.out.println(optional2.orElse("Not present in Optional"));

        printHeader("Reduce 5 : Parallel");
        Stream<String> stream5 =
                Stream.of("k", "r", "u", "t", "i", "k", "s");
        System.out.println(
                stream5.reduce( ""
                        , (val1, val2) -> val1 + val2
                        , (val1, val2) -> val1 + val2
                )
        );

        printHeader("Reduce 6 : Sort then Parallel Concatenate");
        Stream<String> stream6 =
                Stream.of("k", "r", "u", "t", "i", "k", "s");
        System.out.println(
                stream6.sorted()
                        .reduce( ""
                        , (val1, val2) -> val1 + val2
                        , (val1, val2) -> val1 + val2
                )
        );

        printHeader("Collect 1 ");
        Stream<String> stream7 =
                Stream.of("k", "r", "u", "t", "i", "k");
        System.out.println(
                stream7.collect(
                        () -> new StringBuilder()
                        , (s, str) -> s.append(str)
                        , (s1, s2) -> s1.append(s2)
                )
        );

        printHeader("Collect with API collectors");
        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
        System.out.println(
                Stream.of("k", "r", "u", "t", "i", "k")
                        .collect(Collectors.joining(": "))
        ); // k: r: u: t: i: k

        System.out.println(
                Stream.of("krutik", "pati", "cat")
                        .collect(Collectors.averagingInt(s -> s.length()))
        ); //4.333333333333333

        System.out.println(
                Stream.of("k", "r", "u", "t", "i", "k", "a")
                        .filter( s -> vowels.contains(s))
                        .collect(Collectors.joining(": "))
        ); //u: i: a

        System.out.println(
                Stream.of("k", "r", "u", "t", "i", "k", "a")
                        .distinct() // will break if k appears as multiple keys
                        .collect(Collectors.toMap(
                                s -> s
                                , s -> vowels.contains(s)
                        ))
        ); //{a=true, r=false, t=false, u=true, i=true, k=false}

        System.out.println(
                Stream.of("cake", "apricot", "mushroom", "take")
                        .collect(Collectors.toMap(
                                s -> s.length()
                                , s -> s
                                , (duplicate1, duplicate2) -> duplicate1 + ", " + duplicate2
                        ))
        ); // {4=cake, take, 7=apricot, 8=mushroom}


        System.out.println(
                Stream.of("cake", "apricot", "mushroom", "take")
                        .collect(Collectors.toMap(
                                s -> s.length()
                                , s -> s
                                , (duplicate1, duplicate2) -> duplicate1 + ", " + duplicate2
                                , () -> new TreeMap<>() // which map implementation to use
        ))); // {4=cake, take, 7=apricot, 8=mushroom}

        System.out.println(
                Stream.of("cake", "apricot", "mushroom", "take")
                        .collect(Collectors.groupingBy(s -> s.length()))
        ); // {4=[take, cake], 7=[apricot], 8=[mushroom]}

        // Use Set to collect values, instead of List
        System.out.println(
                Stream.of("cake", "apricot", "mushroom", "take")
                        .collect(
                                Collectors.groupingBy(
                                        s -> s.length()
                                        , Collectors.toSet()
                                )
                        )
        ); // {4=[take, cake], 7=[apricot], 8=[mushroom]}

        System.out.println(
                Stream.of("cake", "apricot", "mushroom", "take")
                        .collect(
                                Collectors.groupingBy(
                                        s -> s.length()
                                        , () -> new TreeMap<>()
                                        , Collectors.toSet()
                                )
                        )
        ); // {4=[take, cake], 7=[apricot], 8=[mushroom]}

        System.out.println(
                Stream.of("cake", "apricot", "mushroom", "take")
                        .collect(
                                Collectors.partitioningBy(
                                        s -> s.startsWith("a")
                                )
                        )
        ); // {false=[cake, mushroom, take], true=[apricot]}

        System.out.println(Stream.of("book", "pen", "ruler")
                .map(s -> s.length())
                .collect(Collectors.toSet())
        ); // [3, 4, 5]

        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("d", "e", "f");
        Stream<List<String>> listStream = Stream.of(list1, list2);
        System.out.println(listStream
                .flatMap( l -> l.stream())
                .collect(Collectors.toSet())
        ); // [a, b, c, d, e, f]

        record Person(String name, int age) { }
        Person p1 = new Person("krutik", 35);
        Person p2 = new Person("pati", 32);
        System.out.println(Stream.of(p1, p2)
                .sorted(Comparator.comparing(p -> p.age()))
                .collect(Collectors.toList())
        ); // [Person[name=pati, age=32], Person[name=krutik, age=35]]

        printHeader("Primitive streams");
        int[] ia = {1, 2, 3};
        double[] da = {1.1, 2.1, 3.1};
        long[] la = {1L, 2L, 3L};

        IntStream intStream = Arrays.stream(ia);
        DoubleStream doubleStream = Arrays.stream(da);
        LongStream longStream = Arrays.stream(la);

        IntStream intStream1 = IntStream.of(1,2,3);
        DoubleStream doubleStream1 = DoubleStream.of(1.1, 2.1, 3.1);
        LongStream longStream1 = LongStream.of(1L, 2L, 3L);

        System.out.println(intStream1.count()); //3



    }

    static void printHeader(String content){
        System.out.println("\n============\n" + content + "\n============");
    }
}
