#coding/bestpractices 

- Data abstractions
	- Do not simply push variables out thru getters and setters.
	- Expose abstract interfaces to allow users to manipulate the essence of the data without knowing implementation
- Data/Object Anti-Symmetry
	- Objects hide data behind abstractions and expose functions that operate on data
	- Data structures expose data and have no meaningful functions
	- OOP and objects are appropriate when...
		- add new data types rather than functions
	- Procedural code and data structures are appropriate when...
		- add new functions instead of data types
- Law of Demeter
	- Method f of class C should only call methods of the following:
		- class C
		- object created by f
		- object passed as argument to f
		- object held in instance variable of class C
	- Chaining function calls
		- Okay if the objects that are chained are simply data structures
- Data transfer Objects
	- public variables via getters/setters
	- no functions
	- For Java, see [[Records]]

# References
[[Clean Code by Robert C. Martin]]