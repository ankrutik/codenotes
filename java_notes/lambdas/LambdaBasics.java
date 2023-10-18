package java_notes.lambdas;

/**
 * Inteface I here is a functional interface because it has just 1 abstract method to implement.
 * Default and static methods do not count.
 */
interface I {
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

public class LambdaBasics {
    public static void main(String[] args)
    {
        //pre-java-8
        I pre_java_8_implementation = new I(){
            public void method1(){
                System.out.println("method1");
            }
        };
        pre_java_8_implementation.method1();

        //post-java-8
        I post_java8_1 = () -> {
            System.out.println("method1");
            System.out.println("multiline code");
        };
        post_java8_1.method1();

        I post_java8_2 = () -> System.out.println("method1 single line");
        post_java8_2.method1();
    }
}
