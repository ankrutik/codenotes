#java/concurrency 

The [[Java Memory Model]] uses both the main memory and cache to store shared resources between objects. 

In multi-threaded applications, the value read from cache might be stale as another thread might have updated the value in main memory and the cache was not updated. This is the [[Visibilty Problem]]

The `volatile` keyword solves this by skipping the cache altogether. So reads and writes are to main memory. 

`volatile`
- compiler and runtime are told to not reorder operations on it with other memory operations
- values not stored in registers or caches which can be hidden from other processors
- value is always that which is written by threads
- locking guarantees visibility and atomicity, volatile only guarantees visibility
- design criteria:
	- writes do not depend on current value or ensure that only one thread can write to it
		- many thread may read it
	- variable does not participate in invariants with other variables
	- locking is not required for any other reason while variable is accessed

# Links

# References
https://www.baeldung.com/java-volatile-vs-atomic
[[Java Concurrency In Practice]]
