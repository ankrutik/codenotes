package ankrutik.cast;

import java.util.Arrays;

/**
 * Automatic Value-based object casting is not supported in Method overloading
 */
public class CastingInArguments {

    public static void main(String[] args) {
        CastingInArguments object = new CastingInArguments();
        //object.print(1, 2, 3);
        // won't compile, method print(Integer[]) is ambiguous for the type CastingInArguments

        //object.print(Integer.valueOf(8), Integer.valueOf(9));
        // won't compile, method print(Integer[]) is ambiguous for the type CastingInArguments
        //object.print(Arrays.asList(Integer.valueOf(8), Integer.valueOf(9)));
        // won't compile, method print(Integer[]) is ambiguous for the type CastingInArguments
        
        object.print(new Integer[]{Integer.valueOf(8), Integer.valueOf(9)});
        // this is okay, explicit array is used

        //No issue with differentiating when method is single parameter
        object.print(3);
        object.print(Integer.valueOf(8));
    }

    void print(Integer... a){
        System.out.println("Integer array");
    }

    void print(int... a){
        System.out.println("integer array");
    }

    void print(long... a){
        System.out.println("long array");
    }

    void print(Integer a){
        System.out.println("Integer object");
    }

    void print(int a){
        System.out.println("integer primitive");
    }
}
