# datastructures

### Threads

##### Client Class
```java
// Client class
public class Client {
	...
	// Create a thread
	CustomThread thread1 = new CustomThread(...);
	
	// Start a thread
	thread1.start();
	...
	
	// create another thread
	CustomThread thread2 = new CustomThread(...);
	
	// Start a thread
	thread2.start();
	}
	...
}

// Custom thread class
public class CustomThread extends Thread {
	...
	public CustomThread(...) {
		...
	}
	
	// Override the run method in Runnable
	public void run() {
		// Tell system how to perform this task
		...
	}
	...
}
```

Thread Sleep
============
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

