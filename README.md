# datastructures

### Threads

##### Client Class
```java
// Client class
public class Client { 
	...
	public void someMethod() { 
		...
		// Create an instance of TaskClass
		TaskClass task = new TaskClass(...);

		// Create a thread
		Thread thread = new Thread(task);
    
		// Start a thread
    		thread.start();
		... 
	}
	...
}
// Custom task class
public class TaskClass implements Runnable { 
	...
	public TaskClass(...) {
		...
	}
  	// Implement the run method in Runnable
	public void run() {
		// Tell system how to run custom thread
		...
	}
	... 
}
```

- Runnable interface has to implement run method

### Thread Sleep
```java
public void run() {
		try {
			for(int i = 1; i <= lastNum; i++) {
				System.out.println(" " + i);
				if(i >= 50) {
					Thread.sleep(10);
				}
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
```

- Stops this thread for a specified amount of time

### Thread Yield
```java
public void run() {
	for (int i = 1; i <= lastNum; i++) {
		System.out.print(" " + i);
      	Thread.yield();
	}
}
```

- Temporarily stops this thread and allows others to execute

### Thread Join
```java
public void run() {
	Thread thread4 = new Thread(new PrintChar('c', 40));
	try {
		for (int i = 0; i <= lastNum; i++) {
			System.out.println(" " + i);
			if(i == 50) thread4.join();
		}
	} catch (InterruptedException ex) {
	}
}
```

- waits for this thread to finish

#### Priority
- Priority can be from 1 - 10
- Thread with lower priority cannot execute till all higher priority threads execute
- Defaulted to NORM_PRIORITY
- When all equal priority, equal CPU time (round-robin scheduling)
 
### Thread Controlling Animation

```java
import javax.swing.JApplet;
import javax.swing.JLabel;

public class FlashingText extends JApplet implements Runnable {
	private JLabel jText = new JLabel("Welcome", JLabel.CENTER);
	
	public FlashingText() {
		add(jText);
		new Thread(this).start();
	}
	
	// set the text on/off every 200 milli
	@Override
	public void run() {
		try {
			while(true) {
				if(jText.getText() == null) {
					jText.setText("Welcome");
				} else {
					jText.setText(null);
				}
				Thread.sleep(500);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
	}
}
```

### Threads in GUI Animations


### Thread Pools

- You define a task class by implementing Runnable
- Creating a thread by:
- Runnable task = new TaskClass(task);
- new Thread(task).start();

- This is efficient for a single task, but not efficient for large number of tasks.
- Thread pools are efficient an executing tasks concurrently.
- Java provides the Executor interface for executing tasks in a thread pool and the ExecutorService
	interface for managing and controlling tasks.
- ExecutorService is a subinterface for Executor

			<<interface>>
	java.util.concurrent.Executor
+ execute(Runnable object): void // executes the runnable task

			<<interface>>
	java.util.concurrent.ExecutorService
+shutdown(): void				// shuts down the executor, but allows the tasks in the executor to complete. Once shut down, it cannot accept new tasks
+shutdownNow(): List<Runnable> 	// shuts down the executor immediately and returns the list of unfinished tasks
+isShutdown(): boolean 			// returns true if shut down
+isTerminated(): boolean		// returns true if all the tasks in the pool are terminated
 

- To create an Executor object, use the static methods in the Executors class
- newFixedThreadPool(int) method creates a fixed number of threads in a pool.
- If a thread completes executing a task, it can be reused to execute another task.
- If a thread terminates due to a failure prior to shutdown, a new thread will be created to replace it if all the threads in the pool are not idle and there are tasks waiting for execution.
- The newCachedThreadPool() method creates a new thread if all the threads in the pool are not idle and there are tasks waiting for execution. 
- A thread in a cached pool will be terminated if it has not been used for 60 seconds. 
- A cached pool is efficient for many short tasks.

	java.util.concurrent.Executors
+newFixedThreadPool(numberOfThreads: int): ExecutorService	// Creates a thread pool with a fixed number of threads executing concurrently. A thread may be reused to execute another task after its current task is finished.
+newCachedThreadPool(): ExecutorService						// Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available.


#### Switch to ExecutorDemo.java
- Demonstrates how to used thread pools

#### Thread Synchronization
- Coordinates the execution of the dependent threads.
