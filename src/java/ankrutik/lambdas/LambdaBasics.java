package ankrutik.lambdas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Inteface I here is a functional interface because it has just 1 abstract method to implement.
 * Default and static methods do not count.
 */
interface SimpleInterface {
    void method1();

    /**
     * The moment this method is uncommented, the declaring statements for 
     * post_java8_1 and post_java8_2 will fail with error "The target to this expression must be 
     * a functional interface."
     * @param a
     */
    // void method2();

    default void method2(String a){
        System.out.println(a);
    }

    static void method3(String a){
        System.out.println(a);
    }
}

interface GenericParameterWithReturn<T> {
    boolean process(T t);
}

public class LambdaBasics {
    public static void main(String[] args)
    {
        /**
         * Simple Interface
         */
        //pre-java-8
        System.out.println("Simple Interface");
        System.out.println("Before java 8");
        SimpleInterface pre_java_8_implementation = new SimpleInterface(){
            public void method1(){
                System.out.println("method1");
            }
        };
        pre_java_8_implementation.method1();

        //post-java-8
        System.out.println("After java 8");
        System.out.println("multiple statements implementation");
        SimpleInterface post_java8_1 = () -> {
            System.out.println("method1");
            System.out.println("multiline code");
        };
        post_java8_1.method1();

        System.out.println("single statement implementation");
        SimpleInterface post_java8_2 = () -> System.out.println("method1 single line");
        post_java8_2.method1();

        /**
         * Generic Parameter and Return value
         */

        // single statement, returns value
        System.out.println("Generics and Return Type, Single line");
        GenericParameterWithReturn<Integer> i1_1 = i -> i > 0;
        
        System.out.println(i1_1.process(45));

        // multiple statements, returns value
        System.out.println("Generics and Return Type, Multiple lines");
        GenericParameterWithReturn<Integer> i1_2 = i -> {
            System.out.println("printing something");
            return i > 0;
        };
        System.out.println(
            i1_2.process(54)
        );


        System.out.println("Predicates");
        Predicate<Integer> isGreaterThanZero = i -> i > 0;
        System.out.println(
            isGreaterThanZero.test(45)
        );

        System.out.println("Passing to a check function...");
        System.out.println(check(45, i -> i > 0));
        System.out.println(check(-1, i -> i < 0));
        
        System.out.println("Using BiPredicates");
        BiPredicate<String, Integer> isOfLength = (s, i) -> s.length() == i;
        System.out.println(isOfLength.test("Jack", 4));

        System.out.println("Supplier");
        Supplier<LocalTime> currentTime = () -> LocalTime.now();
        System.out.println(currentTime.get());

        System.out.println("Consumer");
        Consumer<String> printCapital = s -> System.out.println(s.toUpperCase());
        printCapital.accept("abc");
        Consumer<String> capitalize = s -> s.toUpperCase();
        capitalize.accept("def");
        // Following line will not compile because accept() returns void
        // System.out.println(capitalize.accept("xyz"));

        /**
         * Collections which work on single elements accept Consumers in their forEach methods
         * */ 
        List<String> surnames = new ArrayList<>();
        Consumer<String> maintainCapitalSurnames = s -> surnames.add(s.toUpperCase());
        maintainCapitalSurnames.accept("arekar");
        maintainCapitalSurnames.accept("mangaonkar");
        surnames.forEach(s -> System.out.println(s));
        

        System.out.println("BiConsumer");
        Map<String, String> pincodes = new HashMap<String, String>();
        BiConsumer<String, String> mapTownToPin = (town, pin) -> pincodes.put(town, pin);
        Consumer<String> printPinForTown = town -> System.out.println(pincodes.get(town));
        mapTownToPin.accept("Mahim", "400016");
        mapTownToPin.accept("Gundavli", "400093");
        printPinForTown.accept("Mahim");
        /**
         * Collections that work on 2 elements, accept BiConsumers in their forEach methods
         */
        pincodes.forEach((town, pin) -> System.out.println(town + ": " + pin));

        System.out.println("Function");
        Function<String, Integer> length = s -> s.length();
        System.out.println(length.apply("What is the length of this string?"));

        System.out.println("BiFunction");
        BiFunction<String, String, Boolean> contains = (x, y) -> x.contains(y);
        System.out.println(contains.apply("Stream", "ream"));

        System.out.println("Unary Operator");
        UnaryOperator<String> capitalizeOp = s -> s.toUpperCase();
        System.out.println(capitalizeOp.apply("abc"));

        System.out.println("Binary Operator");
        BinaryOperator<String> concatBiOp = (x, y) -> x + y;
        System.out.println(concatBiOp.apply("AC", "DC"));

        System.out.println("Local variables Effectively Final");
        // localVariable will be used in lambda
        int localVariable = 4;

        // following statement will not work, reassigning value before lambda definition 
        // localVariable+=5;
        
        Predicate<Integer> checkSomething = x -> {
            // following statement will not work, reassigning value inside lambda definition
            // localVariable++;
            return x + localVariable > 0;
        };
        
        // following statement will not work, reassigning value after lambda definition
        //localVariable+=2;

        System.out.println(checkSomething.test(6));

        // following statement will not work, reassigning value after lambda call
        //localVariable+=2;

        System.out.println("Bound Methods References");

        String localName = "Krutik";
        Predicate<String> localNameContains_withoutMethodRef = s -> localName.contains(s);
        Predicate<String> localNameContains = localName::contains;
        System.out.println(localNameContains_withoutMethodRef.test("k"));
        System.out.println(localNameContains.test("r"));
        BiPredicate<String, Integer> nameStartsWithOffSet = localName::startsWith;
        System.out.println(nameStartsWithOffSet.test("ru", 1));

        System.out.println("Unbound Methods References");
        Function<String, String> upperCase1 = String::toUpperCase;
        // means Function<String, String> upperCase1 = s -> s.toUpperCase();
        System.out.println(upperCase1.apply("case"));
        BiFunction<String, String, String> concat1 = String::concat;
        // means BiFunction<String, String, String> concat1 = (x, y) -> x.concat(y);
        System.out.println(concat1.apply("ABC", "DEF"));

        System.out.println("Static Method References");
        /**
         * Following will not compile because Collections.sort() returns void and Functions will return
         *  */ 
        // Function<List<String>, List<String>> sort = Collections::sort;

        Consumer<List<String>> sort1 = Collections::sort;
        List<String> listOfString = new ArrayList(Arrays.asList("h", "a", "n"));
        sort1.accept(listOfString);
        System.out.println(listOfString);

        System.out.println("Constructor methods");
        Supplier<StringBuilder> needAStringBuilder = StringBuilder::new;
        // Supplier<StringBuilder> randomize = () -> new StringBuilder();
        System.out.println(needAStringBuilder.get().append("Carmy").append(" The Bear"));
        
        Function<Integer, List<String>> sizedList = ArrayList::new;
        System.out.println(sizedList.apply(4).size());    
        
    }

    /**
     * Declare generic before return type
     * Pass argument
     * Pass lambda definition
     * @param <T>
     * @param t
     * @param lambda
     * @return
     */
    public static <T> boolean check(T t, Predicate<T> lambda){
        return lambda.test(t);
    }
}
