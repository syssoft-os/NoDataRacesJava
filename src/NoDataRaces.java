import java.util.concurrent.locks.ReentrantLock;

public class NoDataRaces {
    private static final int n_threads = 10;
    private static final int count_to = 10000000;

    private static ReentrantLock mutex = new ReentrantLock();
    private static int counter = 0;

    private static void counting ( int up_to ) {
        for (int i=0; i<up_to; i++) {
            mutex.lock();
            counter += 1;
            mutex.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Stop the time the program starts
        long start = System.nanoTime();

        // Create all threads
        Thread threads[] = new Thread[n_threads];
        for (int t=0; t<n_threads; t++)
            threads[t] = new Thread(() -> { counting(count_to); });
        // Start all threads
        for (Thread t : threads)
            t.start();
        // Wait for all threads to finish
        for (Thread t : threads)
            t.join();

        // Stop the time everything is done
        long stop = System.nanoTime();
        double duration_in_msec = (((double) stop) - ((double) start)) / 10e6;

        System.out.printf("counter should be %d\n",n_threads*count_to);
        System.out.printf("counter is %d\n",counter);
        System.out.printf("Execution time %.4f msec\n",duration_in_msec);
    }
}