package ankrutik.collections;

import ankrutik.utility.ExamplesUtil;

import java.util.*;

import static ankrutik.utility.ExamplesUtil.printHeader;

public class SortingDogs {

    public static void main(String[] args) {
        printHeader("Sort Arrays");
        Dog[] dogArray = getDogArray();
        System.out.println(Arrays.toString(dogArray));
        Arrays.sort(dogArray);
        System.out.println(Arrays.toString(dogArray));

        printHeader("Sorting Collections");
        List<Dog> dogList = getDogsList();
        System.out.println(dogList);
        Collections.sort(dogList);
        System.out.println(dogList);

        printHeader("Using Comparator with Arrays");
        dogArray = getDogArray();
        Comparator<Dog> byName = Comparator.comparing(
                dog -> dog.getName());
        System.out.println(Arrays.toString(dogArray));
        Arrays.sort(dogArray, byName);
        System.out.println(Arrays.toString(dogArray));

        printHeader("Using Comparator with Lists, Reversed Example");
        dogList = getDogsList();
        Comparator<Dog> byNameReversed = Comparator.comparing(
                Dog::getName
        ).reversed();
        System.out.println(dogList);
        Collections.sort(dogList, byNameReversed);
        System.out.println(dogList);


    }

    private static List<Dog> getDogsList() {
        List<Dog> dogList = new ArrayList<Dog>(List.of(
                new Dog(3, "Rover")
                , new Dog(5, "Moti")
                , new Dog(1, "Spot")));
        return dogList;
    }

    private static Dog[] getDogArray() {
        Dog[] dogArray = {new Dog(3, "Rover")
                , new Dog(5, "Moti")
                , new Dog(1, "Spot")};
        return dogArray;
    }
}

class Dog implements Comparable<Dog>{
    int age;
    String name;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Dog dog) {
        // logic delegated to Integer
        return Integer.compare(this.age, dog.age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
