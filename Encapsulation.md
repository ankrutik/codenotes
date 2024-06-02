#design #object-oriented 

## Publication and escape
- Publishing an object means making it's internal code available outside its current scope by means of
	- storing reference to it
	- returning it from non-private method
	- passing it to method of another class
- When publishing happens when not intended, it is said to have escaped.
- Encapsulating has benefits here:
	- makes analyzing correctness easier
	- harder to violate design constraints
- Inner classes contain hidden reference to enclosing instance

# References
[[Java Concurrency In Practice]]