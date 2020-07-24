[Reference](https://www.linkedin.com/learning/parallel-and-concurrent-programming-with-java-1/)
[Reference](https://www.linkedin.com/learning/parallel-and-concurrent-programming-with-java-2/)

>## **Parallel Computing Hardware**
1. Parallel vs Sequential Execution
2. [Flynn's taxonomy](https://en.wikipedia.org/wiki/Flynn%27s_taxonomy)
3. Shared memory system - Uniform(SMP - Symmetric Multi Processing) vs Non-Uniform
4. Cache coherency handling in SMP
4. Distributed memory system - Mulitiple processors connected over network with each having it's own memory

>## **Mutual Exclusion**
1. Data race
2. [Use lock](MutualExclusionDemo.java)
3. If we are sharing simpler like counter, we can consider java.util.concurrent.atomic
4. [Atomic Integer](AtomicVariableDemo.java)
5. Intrinsic Locks - Every java object has an intrinsic lock associated with it
6. static vs non-static synchronized methods
7. synchronized statement
   ```java
   synchronized(Shopper.class){
     garlicCount++;
   }
   ```

>## **Reentrant Lock**
1. If a thread tries to lock already locked mutex, it will enter into deadlock
2. Reentrant mutex is a particular mutex that can be locked multiple times by the same mutex
3. Must be unlocked equal number of times as it was locked to be available for other threads
4. Works in multiple method calling being synchronized on the same lock
5. Also works in recursion calls
6. Also called recursive mutex/lock
7. ReentrantLock, ReentrantReadWriteLock.ReadLock, ReentrantReadWriteLock.WriteLock
8. Java doesn't contains normal lock but only ReentrantLock
9. [Use case of ReentrantLock](ReentrantLockDemo.java)
10. getHoldCount()

>## **Try Lock**
1. Non-blocking lock/acquire method for mutex
2. Return type boolean

>## **ReentrantReadWriteLock**
1. readLock, writeLock; both returns lock object on which we call lock & unlock methods
2. [Demo](ReadWriteLockDemo.java)

