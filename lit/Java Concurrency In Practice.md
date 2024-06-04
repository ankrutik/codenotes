#java/concurrency 

`@ThreadSafe` annotation
- class is thread safe
- maintainers alerted for changes

In the absence of synchronization, compiler, hardware, runtime take substantial liberties with timings and ordering of actions like caching variables in registers or processor-local caches.

When JVM starts, it creates threads for
- housekeeping like garbage collection, finalization
- main thread

# Thread Safety
More about protecting data than about structure of code.
## Synchronization options
- `synchronized`
- `volatile`
- explicit locks
- atomic variables
## Invariants
conditions or states of data of an object that signify the object to be in a valid state.
## Simple solutions first
1. Don't share state variable across threads
2. Make state variable immutable
3. Use synchronization whenever accessing state

Far easier to design a class to be thread-safe from ground up than to retrofit.

Good object-oriented design principles for thread safe design:
- encapsulation
- immutability
- clear specifications of invariants

Make your code right first, then fast.

Pursue optimization measures only if:
- your performance measurements and requirements indicate
- your optimizations actual make a difference

Class conforming to specifications:
- invariants constraint object state
- postconditions describe effects of operations

Thread safety under following conditions:
- accessed from multiple threads
- regardless of scheduling or interleaving  of threads by runtime env
- no additional sync or co-ordination at calling code

Thread safe classes encapsulate synchronization so clients don't need to.
Stateless objects are always thread safe.
*Design to keep most logic in stateless objects.*

Race condition occurs when correctness depends on relative timing or interleaving of multiple threads by run time.

Check-then-act race condition:
- you observe X to true
- based on X you decide to act A
- between observation and action, state of X has changed

Lazy initialization is to defer initialization of an object till the first time it is needed.

Operations A and B are atomic with respect to each other if from perspective of thread executing A, other thread executing B has either executed all of B or none of it.

Compound actions sequences:
- Check-then-act
- read-modify-write
- put-if-absent

`java.util.concurrent.atomic` package for atomic variable classes.

When multiple variables participate in an invariant, they are not independent. The value of one constrains the allowed values of others. In an atomic operations, when updating one you need to update the other.

Java's built-in or intrinsic lock solution is the `synchronized` block.

`synchronized` block has 2 parts:
- lock: reference to an object
- block: .. of code guarded by above lock

`synchronized` method is a shorthand to: 
- a block that spans an entire method
- with a lock that is the object on which method is called

Every java object can act as a lock for purposes of synchronization. These built-in locks are called intrinsic or monitor locks. 

These are mutexes or mutually exclusive locks. If thread A has acquired a lock, then thread B must block(wait) until A releases it.

These locks are acquired and released automatically.
- only way to acquire: enter a synchronized block/method that the lock is guarding
- only way to release: exit a synchronized block/method that the lock is guarding by normal flow or exception being thrown

**Reentrancy**
A thread can re-acquire a lock that it already holds. This reentrancy behaviour is implemented at per-thread than per-invocation. Each lock is associated with an acquisition count and owning thread. When acquisition count is zero, lock is unheld. When acquired, it is incremented by one. When re-acquired, count is incremented again. Each time the thread releases the lock, the count is decremented. Reentrancy saves from deadlocks, thread waiting to acquire a lock that it already holds.

All accesses to a variable must be made by the same lock. Each mutable variable must be guarded by the same lock. Make this information very clear to maintainers.

For every invariant that involves more than one variable, all the variables must be guarded by the same lock.

Be careful not to make scope of a synchronized block too small. Acquiring and releasing locks have some overhead.

When implementing a synchronization policy, do not sacrifice simplicity/safety for the sake of performance.

Avoiding holding locks for lengthy operations like network or console I/O.

# Sharing Objects
There is no guarantee that operations in one thread will be performed in the order given by the program.

Stale data can cause confusing, hard to reproduce and diagnose problems like
- unexpected exceptions
- corrupted data structures
- inaccurate computations
- infinite loops

Mutable long and double variables
- JVM requires fetch and store operations to be atomic except for these 2 where the 2 16bit parts can be worked on by different threads
- use only with `volatile`

Visualize locking to be about memory visibility and not just mutual exclusion.

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

## Publication and escape
- Publishing an object means making it's internal code available outside its current scope by means of
	- storing reference to it
	- returning it from non-private method
	- passing it to method of another class
- When publishing happens when not intended, it is said to have escaped.
- Encapsulating has benefits here:
	- makes analyzing correctness easier
	- harder to violate design constraints

## Safe construction practices
- Do not let `this` reference escape
	- Inner classes contain hidden reference to enclosing instance
- Creation of a thread is alright but do not start thread in the constructor

## Thread Confinement
- When an object is confined for use within a single thread, it is thread-safe
- Done as part of design
- Examples
	- eg. connection pooling
- Ad-hoc thread confinement
	- Confinement responsibility entirely on implementation
	- Fragile
- Stack thread confinement
	- Object can be reached only via local variables
	- Needs clear documentation
- `ThreadLocal`
	- implement a per thread value with value holding object
	- do not abuse as global variables

## Immutable Objects
- always thread safe
- Design criteria:
	- state cannot be modified after construction
	- all fields are final
		- documenting to maintainers that value will not change
		- Fields should be `private` till need to be made public, `final` till they need to be changed
	- `this` reference does not escape during construction
- Whenever group of related data items must be acted on atomically, consider an immutable holder class for them

## Safe publication idioms
- initialize object from static initializer
- store reference to it in `AtomicReference` or `volatile` field
- store reference to it in `final` field of properly constructed object
- store reference to it in a field guarded by a lock
Safely published, effectively immutable objects can be used safely by any thread without additional synchronization.

## Care of objects by mutability
- immutable objects can be safely published thru any mechanism
- effectively immutable objects must be safely published
- mutable objects must be safely published, must be either thread safe or guarded by a lock

## Policies
- Thread confinement
	- owned and modified by exclusively 1 thread
- Shared read-only
	- accessed without synchronization, written by 1 thread
	- immutable and effectively immutable
- Shared thread-safe
	- performs synchronization internally to allow free usage of public interface by multiple threads
- Guarded
	- accessed thru lock

# Composing Objects
## Design process
- Identify variables that form the object state
- Identify the invariants that constrain states
- Established policy for concurrent access to object state  
## Visualise the scope of the object states
Object state will consists of its fields
- If they are of the primitive type, then all primitive variables for the state 
- if the object has feels that references to other objects, then the variables of those objects will be part of the state as well.  

Design decisions:
- What is the State space or complete set of states that an object can take ?
- What are the Invariants that define the valid states? 
	- Encapsulation may be needed. 
- What are the Post conditions that will define the valid state transitions? 
	- Operations will need to be atomic. 
## State dependent operations.
If precondition does not hold on the operation should fail. But in a concurrent program, the preconditions might become true later. Using built-in mechanisms like weight and notify can be difficult to use correctly, **use existing library classes such as blocking queues or semaphore** instead.
