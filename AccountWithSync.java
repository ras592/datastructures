package datastructures;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class AccountWithSync {
	private static Account account = new Account();
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		// create and launch 100 threads
		for(int i = 0; i < 100; i++) {
			executor.execute(new AddAPennyTask());
		}
		
		executor.shutdown();
		
		// wait until all the tasks are finished
		while(!executor.isTerminated()) {	
		}
		
		System.out.println("What is balance? " + account.getBalance());
	}
	
	public static class AddAPennyTask implements Runnable {
		public void run() {
			account.deposit(1);
		}
	}
	
	private static class Account {
		private static Lock lock = new ReentrantLock(); // create a lock
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
		public void deposit(int amount) {
			lock.lock(); // acquire the lock
			
			// This is delayed to magnify the data-corruption
			try {
				int newBalance = balance + amount;
				
				Thread.sleep(5);
				
				balance = newBalance;
			} catch (InterruptedException ex) {
				
			} finally {
				lock.unlock(); // finally release the lock
			}
		}
	}
}

