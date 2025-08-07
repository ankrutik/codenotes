#java

- Package
	- `java.util.Comparator<T>` 
	-  `java.lang.Comparable<T>`
- Both... 
	- functional interfaces
	- used for sorting
- ! Keep Comparable classes consistent with their `equals`
- ? When compare logic can be kept inside class...
	- implement `Comparable`
- ? When compare logic has to be kept outside class...
	- use `Comparator`
# `Comparable<T>`
- `int compareTo(T)`
	- Positive when `this` is larger than parameter
	- `0` when `this` is equal to parameter
		- ! Keep this logic consistent with `equals`
	- Negative when `this` is smaller than parameter
	-  Delegate logic to String or Integer attributes of object

# `Comparator<T>`
- $ Use when classes do not implement `Comparable`
- `int compare(T obj1, T obj2)`
	- Logic same as `Comparable`