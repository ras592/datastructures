package datastructures;

import java.util.concurrent.*;

public class AccountWithoutSync {
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
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
		public void deposit(int amount) {
			int newBalance = balance + amount;
			
			// This is delayed to magnify the data-corruption
			try {
				Thread.sleep(1);
			} catch (InterruptedException ex) {
				
			}
			
			balance = newBalance;
		}
	}
}
