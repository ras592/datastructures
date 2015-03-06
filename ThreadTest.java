package datastructures;

public class ThreadTest {
	public static void main(String[] args) {
		Runnable print100 = new TaskClass(100, "Hi");
		Runnable print1000 = new TaskClass(1000, "Someone");
		Runnable print10000 = new TaskClass(10000, "Bye");
		
		Thread thread1 = new Thread(print100);
		Thread thread2 = new Thread(print1000);
		Thread thread3 = new Thread(print10000);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
}

// custom task -- must implement runnable
class TaskClass implements Runnable {
	private int timesRun;
	private String greeting;
	
	public TaskClass(int n, String s) {
		timesRun = n;
		greeting = s;
	}
	
	@Override
	public void run() {
		try {
			for(int i = 0; i < timesRun; i++) {
				System.out.println(greeting + " ");
				if(greeting.equals("Someone") && i >= 150) {
					Thread.sleep(1);
				}
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}