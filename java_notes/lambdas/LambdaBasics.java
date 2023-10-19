package java_notes.lambdas;

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
        SimpleInterface pre_java_8_implementation = new SimpleInterface(){
            public void method1(){
                System.out.println("method1");
            }
        };
        pre_java_8_implementation.method1();

        //post-java-8
        SimpleInterface post_java8_1 = () -> {
            System.out.println("method1");
            System.out.println("multiline code");
        };
        post_java8_1.method1();

        SimpleInterface post_java8_2 = () -> System.out.println("method1 single line");
        post_java8_2.method1();

        /**
         * Generic Parameter and Return value
         */

        // single statement, returns value
        GenericParameterWithReturn<Integer> i1_1 = i -> i > 0;
        System.out.println(i1_1.process(45));

        // multiple statements, returns value
        GenericParameterWithReturn<Integer> i1_2 = i -> {
            System.out.println("printing something");
            return i > 0;
        };
        System.out.println(i1_2.process(54));
    }
}
