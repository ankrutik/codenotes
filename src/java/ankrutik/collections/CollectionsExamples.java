package ankrutik.collections;

import ankrutik.utility.ExamplesUtil;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

import static ankrutik.utility.ExamplesUtil.printHeader;

public class CollectionsExamples {
    public static void main(String[] args) {

        printHeader("Add Operation on unmodifiable collection");
        List<String> names;
        try{
            names = Arrays.asList("A", "B", "C");
            names.add("D");
            // java.lang.UnsupportedOperationException
        } catch(Exception e){
            System.out.println(e.getClass());
        }
        try{
            names = List.of("A", "B", "C");
            names.add("D");
            // java.lang.UnsupportedOperationException
        } catch(Exception e){
            System.out.println(e.getClass());
        }

        try{
            names = new ArrayList<>(List.of("A", "B", "C"));
            for(String name : names){
                names.add("D");
                // java.util.ConcurrentModificationException
            }
        } catch(Exception e){
            System.out.println(e.getClass());
        }

        printHeader("Using List Iterator");
        names = new ArrayList<>(List.of("A", "B", "C"));
        ListIterator<String> listIterator = names.listIterator();
        while(listIterator.hasNext()){
            if("B".equals(listIterator.next()))
                listIterator.add("B1");
        }
        System.out.println(names);
        // [A, B, B1, C]

        printHeader("Using CopyOnWriteArrayList");
        CopyOnWriteArrayList<String> conNames = new CopyOnWriteArrayList<>(List.of("A", "B", "C"));
        for(String name : conNames){
            if("B".equals(name))
                conNames.add("B1");
        }
        System.out.println(conNames);
        // [A, B, C, B1]

        printHeader("Removing using Iterator");
        names = new ArrayList<>(List.of("A", "B", "C", "D"));
        Iterator<String> iterator = names.iterator();
        while(iterator.hasNext()){
            if("B".equals(iterator.next()))
                iterator.remove();
        }
        System.out.println(names);
        // [A, C, D]

        printHeader("Removing using removeIf and not Iterator");
        names = new ArrayList<>(List.of("A", "B", "C", "D"));
        names.removeIf(element -> "B".equals(element));
        // Alternate
        // names.removeIf("B"::equals);
        System.out.println(names);
        // [A, C, D]

        printHeader("Using CopyOnWriteSet");
        CopyOnWriteArraySet<String> copySet = new CopyOnWriteArraySet<>(List.of("A", "B", "C"));
        for (String name : copySet){
            if("B".equals(name))
                copySet.add("B1");

            System.out.println(name);
            // iteration will not print B1
        }
        System.out.println("Iteration ended, B1 was added...");
        // A B C Iteration ended, B1 was added...
        System.out.println(copySet);
        // [A, B, C, B1]

        printHeader("Removing from map using stream");
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1); map1.put("B", 2);
        map1.put("C", 3); map1.put("D", 4);
        System.out.println(map1);
        map1 = map1.entrySet().stream()
                .filter(e -> e.getValue() != 3)
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        System.out.println(map1);
        // {A=1, B=2, C=3, D=4}
        // {A=1, B=2, D=4}
    }
}
