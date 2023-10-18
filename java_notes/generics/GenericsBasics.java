package java_notes.generics;
import java.util.ArrayList;

public class GenericsBasics{

    public static void demo_basics(){
        
        /**
         * - Define generic list
         * - All elements can be stored and accessed as Objects
         * - Maintained for back support before JDK5
         */
        ArrayList nonSpecificList = new ArrayList();
        nonSpecificList.add(90);
        nonSpecificList.add("ninety");
        nonSpecificList.add("thirty");
        System.out.println("Printing objects saved inArrayList nonSpecificList = new ArrayList()");
        for(Object o : nonSpecificList)
            System.out.println(o);
        //-------------------------
    }

    public static void main(String[] args) {
        demo_basics();
    }
}