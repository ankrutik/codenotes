#java 

- sequence of data
- not a data structure that holds data
- ! Closed once pipeline ends, cannot re-use
- $ Think in pipeline structure/view...
	- source
	- intermediate operations
		- operations carried out in order
		- `filter()`
	- terminal operations
		- kicks off the pipeline
		- `count(), forEach()`
- ? pipeline can improve efficiency 
	- requires terminal
	- list of operations and order
	- helps JDK to optimize
- ! Streams do not implement the `Iterable` interface
	- Cannot be used with traditional `forEach` statement

# Usage Insight
- Use APIs inside reduce, collect, sorted instead of explicit coding
- Think from pipeline view perspective
- 

# Quick Example
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

- streams are lazy
- `Stream.of()`
	- Create ad-hoc stream

# Common methods
## distinct
- uses `equals()` to remove duplicates
## peek
- Intermediate operation
- Process element at that point.
- #bestpractice Use to print values when debugging
## forEach
- Terminal operation
- Process each item from above pipeline
## anyMatch
- Terminal operation
- Stop at first match
## limit
- Intermediate Operation
- Limit pipeline at the point before terminal
- stateful, short circuiting
## sorted
- Intermediate Operation
- sort values up till that point in pipeline

# Creating streams
## Collections
```java
Arrays.stream();
arraylist.stream();
Stream.of();
```

## Maps
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

## Files
```
Files.lines(Path path);
```
See [[Reading Files#Java#Streams|reading files with streams]]

## Infinite streams
```java
Stream.generate(()-> {return (int)Math.rand()});
Stream.iterate(2, n -> n + 2);
```

Make it finite using a `limit()` short circuit...
```java
Stream.iterate(2, n -> n + 2)
.limit(10)
.forEach(System.out::println);
```

# Terminal Ops
*Reductions* are **terminal** operations that **combine all the contents** of a stream into a **single** primitive or Object (like Collection) **return**.

| Method                                                           | Return Value  | Reduction?                       |
| ---------------------------------------------------------------- | ------------- | -------------------------------- |
| `count()`                                                        | `long`        | Yes                              |
| `min(Comparator), max(Comparator)`                               | `Optional<T>` | Yes                              |
| `findAny(), findFirst()`                                         | `Optional<T>` | No, may not look at all elements |
| `anyMatch(Predicate), allMatch(Predicate), noneMatch(Predicate)` | boolean       | Yes                              |
| `forEach()`                                                      | void          | No, it does not return           |
| `reduce(T identity/StartingPouint, BinaryOperator<T>)`           | varies        | Yes                              |
| `collect()`                                                      | varies        | Yes                              |
- min and max
	- Takes [[Comparator]]
	- Java will figure out what to do
## reduce
1. Identity
	1. Starting point of reduction
2. Accumulator
	1. take 2 values, operate
	2. take previous value and next, go to 1.1.
3. Combiner
	1. Combine output of multiple Accumulators

### Version 1, Accumulator
- Parameters
	- `BinaryOperator<T>` accumulator
- Returns
	- `Optional<T>`

### Version 2, Identity, Accumulator
- Parameters
	- `T` identity
	- `BinaryOperator<T>` accumulator
- Returns
	- `T`

### Version 3, Identity, Accumulator, Combiner
- Parameters
	- `T` identity
	- `BiFunction` accumulator
	- `BinaryOperator<T>` combiner
- Returns
	- `T`
- Difference between `BiFunction` and `BinaryOperator`
	- BiFunction takes different types as parameters 
	- BinaryOperator takes same types as parameters

## collect
- mutable reduction
- Streams into other forms like Maps, Lists, Sets
### Version 1, supplier, accumulator, combiner
- Parameter
	- `Supplier<T>` supplier
	- `BiConsumer<T, U>` accumulator
	- `BiConsumer<T, T>` combiner
- Return
	- `T`

## Version 2, Predefined API collectors
```java
Stream.of("k", "r", "ut", "i", "k")
.collect(Collectors.joining(", "));

// Few exmaples
```

### Single Value
```java
Collectors.joining(", ")
Collectors.averagingInt(s -> s.length())
```

### Map
Without duplicate handling
```java
Collectors.toMap(
	  s-> s
	, s-> s.length()
)
```

With duplicate handling, or merger
```java
Collectors.toMap(
	  s -> s.length()
	, s
	, (s1, s2) -> s1 + ", " + s2
);
```

### Grouping By
Grouping
```java
Collectors.groupingBy(  
        s -> s.length()  // key
        , () -> new TreeMap<>() // use a TreeMap for mapping  
        , Collectors.toSet()  // use a Set to store values
)
```

Partitioning
```java
Collectors.partitioningBy(  
        s -> s.startsWith("a")  
)

Collectors.partitioningBy(  
        s -> s.startsWith("a")
        , Collectors.toSet() // use a set to store values  
)
```

## Map/Transform
- creates one-to-one mapping between elements in the stream and elements in the next stage of the stream
- ! Think like it transforms the stream in another form

```java
Stream.of("book", "pen", "ruler")  
	.map(s -> s.length())  
	.collect(Collectors.toSet())
```

### flatMap()
```java
Stream<List<String>> listStream = Stream.of(list1, list2);  
System.out.println(
	listStream  
        .flatMap( list -> list.stream())  
        .collect(Collectors.toSet())  
);
```

### sorted with Compartor
```java
record Person(String name, int age) { }  
Person p1 = new Person("krutik", 35);  
Person p2 = new Person("pati", 32);  
System.out.println(
	Stream.of(p1, p2)  
        .sorted(Comparator.comparing(p -> p.age()))  
        .collect(Collectors.toList())  
);
```

# Primitive Streams
- `IntStream`
	- int, short, byte, char
- `DoubleStream`
	- double, float
- `LongStream`
	- long

```java
IntStream intStream0 = Arrays.stream({1, 2, 3}); 
IntStream intStream1 = IntStream.of(1,2,3);
```

Common operations...
- min
- max
- sum
	- Only method to return primitives
- average
All methods return `OptionalInt, OptionalDouble, OptionalLong`

## Summary Stats
```java title:"Example of summary statistics"
IntSummaryStatistics stats = IntStream.of(1,2,4,5).summaryStatistics();
```

## Mapping between...
- *Type*Stream to*Type*Stream
	- map()
- *Type*Stream to Stream
	- mapToObj()
- *TypeA*Stream to *TypeB*Stream
	- mapTo*TypeB*() 
# Functional Interfaces
- `Supplier<T>`
	- `T get()`
- `Consumer<T>`
	- `void accept(T)`
- `BiConsumer<T, U>`
	- `void accept(T, U)`
- `Function<T, R>`
	- `R apply(T)`
- `BiFunction<T, U, R>`
	- `R apply(T, U)`
- `UnaryOperator<T>`
	- `T apply(T)`
- `BinaryOperator<T>
	- `T apply(T, T)`

# Optional
- box that may or may not be empty

```java
Optional optional = Optional.empty();
optional = Optional.of("a");
optional = Optional.ofNullable(varThatMayOrMayNotBeNull);

if(optional.isPresent()) System.out.println(optional.get()) ;

optional.ifPresent(s -> System.out.println(s));

optional.orElse(s -> "Not present");
optional.orElseGet(() -> "Not present");
```

# Parallel Streams
- `parallel()` in Stream
- `parallelStream()` in Collections
- ! Be careful if order is important
