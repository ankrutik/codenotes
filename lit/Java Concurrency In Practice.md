#java/concurrency 

`@ThreadSafe` annotation
- class is thread safe
- maintainers alerted for changes

In the absense of synchronization, compiler, hardware, runtime take substantial liberties with timings and ordering of actions like caching variables in registers or processor-local caches.

When JVM starts, it creates threads for
- housekeeping like garbage collection, finalization
- main thread

# Thread Safety
Thread safety is more protecting data than about structure of code.

Synchronization options:
- `synchronized`
- `volatile`
- explicit locks
- atomic variables

**Invariants** mean conditions or states of data of an object that signify the object to be in a valid state.

Simple solutions first:
1. Don't share state variable across threads
2. Make state variable immutable
3. Use synchronization whenever accessing state

Far easier to design a class to be thread-safe from ground up than to retrofit.

Good object-oriented design principles for thread safe design:
- encapsulation
- immutability
- clear specifications of invariants

Make your code right first, then fast.

Pursue optimisation measures only if:
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


