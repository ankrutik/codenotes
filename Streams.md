#java 

- sequence of data
- not a data structure that holds data
- pipeline can improve efficiency 
	- requires terminal
	- list of operations and order
	- helps JDK to optimize
- multiple intermediate operations
- pipeline structure/view
	- source
	- intermediate operations
		- operations carried out in order
		- `filter()`
	- terminal operations
		- kicks off the pipeline
		- `count(), forEach()`

```java
List<Double> temperatures = Arrays.asList(100.2, 98.0, 67.5, 103.4);  
System.out.println("Count is:" +  
        temperatures.stream()           // SOURCE  
        .peek(System.out::println)      // INTERMEDIATE OP  
        .filter(t -> t > 100)    // INTERMEDIATE OP  
        .peek(System.out::println)      // INTERMEDIATE OP  
        .count())                       // TERMINAL OP  
;

Output:
100.2
100.2
98.0
67.5
103.4
103.4
Count is:2
```


- streams are lazy
- `Stream.of()`
	- Create ad-hoc stream

# peek
- Intermediate operation
- Process element at that point.
- #bestpractice Use to print values when debugging
# forEach
- Terminal operation
- Process each item from above pipeline
# anyMatch
- Terminal operation
- Stop at first match
# limit
- Intermediate Operation
- Limit pipeline at the point before terminal
# sorted
- Intermediate Operation
- sort values uptil that point in pipeline

```java
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
```


Maps are not collection and stream ready. Use `entrySet()` to get a collection view of the map. Then use stream() on that.

```java
Map<String, Integer> nameAge = new HashMap<>();  
nameAge.put("Krutik", 35);  
nameAge.put("Pratiksha", 32);  
nameAge.put("Cat", 5);  
System.out.println(nameAge.entrySet().stream()  
        .peek(System.out::println) // prints nothing  
        .count());
```