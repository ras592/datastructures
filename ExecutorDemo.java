package datastructures;

import java.util.concurrent.*;

/*
 * The executor creates three threads to execute three tasks concurrently.
 * But if ExecutorService executor = Executors.newFixedThreadPool(1);
 * Then the three tasks would be executed sequentially since there is only one thread.
 * 
 */

public class ExecutorDemo {
	public static void main(String[] args) {
		// Create a fixed thread pool with maximum three threads
		ExecutorService executor = Executors.newFixedThreadPool(3);
		// ExecutorService executor = Executors.newCachedThreadPool();
		
		// ExecutorService executor = Executors.newCachedThreadPool();
		// Would create enough threads for any # of Tasks
		
		// Submit runnable tasks to the executor
		executor.execute(new PrintChar('a', 1000));
		executor.execute(new PrintChar('b', 1000));
		executor.execute(new PrintNum(1000));
		
		// Shut down the executor
		executor.shutdown();
	}
}
