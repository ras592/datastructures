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
