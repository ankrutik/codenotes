#java 

# Usage Insights
- For final, static, public constant collections, use the `..of()` factory method
- When overriding hashcode and equals, use the same variables
# List
- List
	- ArrayList
		- fast iteration and random access
		- use when
			- insertion/deletion not likely 
	- LinkedList
		- use when
			- frequent insertion/deletion
			- no random access by index
		- add, addFirst, addLast, removeFirst, removeLast
	- Stack
		- LIFO
		- push, peek, pop
		- use deque


```java title:"Immutable factory methods"
Arrays.asList(T...a)
List.of(E... elements)
List.copyOf(Collection coll)
```
# Set
- HashSet
	- use when
		- hashing
		- sorting and ordering not needed
- LinkedHashSet
	- use when
		- hashing
		- order needed
- TreeSet
	- natural or custom ordering
	- use when
		- sorting needed
	- `ClassCastException` when you add an Object that does not implement `Comparable`

# Map
- HashMap
	- use when
		- sorting, ordering not needed
	- performance depends on key hashcode
- LinkedHashMap
	- use when
		- ordering is needed
- TreeMap
	- use when
		- sorting is needed on key
- Hashtable
	- use when
		- thread-safety is needed on HashMap
		- Okay with slowness
		- null not allowed

```java title:"Common useful methods"
entrySet()  // Set view
forEach(BiConsumer)
putIfAbsent(Key, Value)
Collection<Values> values()
containsKey(K)
containsValue(V)
```

# Queue
- Queue operations
	- throws exception
		- element, add, remove
	- returns special value
		- peek, offer, poll
- `ArrayDeque
	- double ended queue
	- use when
		- faster than Stack, when used as stack
		- faster than LinkedList, when used as queue
	- use as *x*First, *x*Last
		- Throws exception
			- get, add, remove
		- Returns special value
			- peek, offer, poll
- `PriorityQueue
	- use when
		- sorting needed, natural or custom
	- `Comparator.comparing(? implements Comparable)` can be used for custom ordering
		- primitives can't be used because no `Comparable` implementation

# Iterating Collections
- `ConcurrentModificationException` if list modified during looping
- List
	- ListIterator.add(E)
		- will add where the iterator is at 
	- Iterator does not have add
	- remove(), removeIf(Predicate)
- Set
	- addAll(Collection) : deferred
	- remove(), removeIf(Predicate)
- Map
	- putAll(Collection) : deferred
	- remove()
- Concurrency is needed?
	- CopyOnWriteArrayList
	- CopyOnWriteArraySet
	- ConcurrentHashMap
	- Caveats
		- A copy is maintained to which elements will be added. 
		- ! This means while iterating, the added elements will not be listed
		- For CopyOnWriteArrayList and CopyOnWriteArraySet, the additions will appear to be at the end of the collections

# Sorting
- See [[Comparable and Comparator]]
- ? If you have an array...
	- Use `Arrays.sort(...)`
- ? If you have collections...
	- Use `Collections.sort(...)`
- Both will modify the array or list
- ! Passing immutable list from `Arrays.asList()` or `List.of()` will throw `UnsupportedOperationException`

```java title:"Sort Arrays with Comparator"
Comparator<Dog> byName = Comparator.comparing(  
        dog -> dog.getName());    
Arrays.sort(dogArray, byName);    
```

```java title:"Sort Lists with Comparator, reversed"
Comparator<Dog> byNameReversed = Comparator.comparing(  
        Dog::getName  
).reversed();  
Collections.sort(dogList, byNameReversed);
```
# Common methods
```java title:"removeIf(Predicate p)" 
coll.removeIf(a -> a.startsWith("pre"));
```


```java title:"forEach(Consumer c)"
coll.forEach(ele -> System.out.println(ele));
```

