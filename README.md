# NoDataRaces (Java)

In this repository, different variants of a multi-threaded Java program are shown that deal with data
races while accessing a shared variable `counter`:

1. No protection at all, just access `counter`, so lots of data races happen.
2. Still no protection, but the execution time of the threads is very short, so all access happens in the first time slot and the probability for a data race is quiet low. Nevertheless, data races can happen.
3. Atomic integer. No data races. Best solution for this type of synchronization problem.
4. Using a synchronized method. No data races anymore but no parallelism either; the threads are all serialized.
5. Synchronized block while the counter variable is accessed. No data races.
6. Sempahores. No data races.
7. Reentrant locks. No data races.
