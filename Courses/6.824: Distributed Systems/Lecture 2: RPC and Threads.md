
**Threads**
1. I/O Concurrency
2. Parallelism
3. Convenience - Polling
4. Using event-driven approach we might get I/O Concurrency but will not get parallelism. But if we can eliminate huge number of threads(as they will take considerable space),
 we can justify to event-driven approach with a little overhead. Basically a thread with while loop serving each request.

**Thread Challenges**
1. Shared memory 
   1. Causing race condition
   2. Use mutex
2. Co-ordination
3. Deadlock
