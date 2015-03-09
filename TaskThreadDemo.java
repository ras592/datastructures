package datastructures;

public class TaskThreadDemo {

	public static void main(String[] args) {
		// create tasks
		Runnable printA = new PrintChar('a', 1000);
		Runnable printB = new PrintChar('b', 1000);
		Runnable print100 = new PrintNum(1000);
		
		// Create threads
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);
		
		// start threads
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

// the task for printing a character a specified number of times
class PrintChar implements Runnable {
	private char charToPrint; // character to be printed
	private int times; // The number of times to repeat
	
	// construct a task with specified character and number of times to print the character
	public PrintChar(char c, int t) {
		charToPrint = c;
		times = t;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < times; i++) {
			System.out.println(charToPrint);
		}
	}
}

// task for printing i to n for a given n
class PrintNum implements Runnable {
	private int lastNum;
	
	// construct a task for printing 1 - n
	public PrintNum(int n) {
		lastNum = n;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= lastNum; i++) {
			System.out.println(" " + i);
		}
	}
}