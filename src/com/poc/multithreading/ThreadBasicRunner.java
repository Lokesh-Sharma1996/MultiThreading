package com.poc.multithreading;

public class ThreadBasicRunner {

	public static void main(String[] args) throws InterruptedException {
		Task1 thread1 = new Task1();
		thread1.start();
		
		Task2 runnable = new Task2();
		Thread thread2 =  new Thread(runnable);
		thread2.start();
		
		thread1.join();
		thread2.join();
	}
}

class Task extends Thread{
	private int number;

	public Task(int number) {
		this.number = number;
	}
	
	public void run() {
		System.out.println("\nTask "+ number +" starts+++++++++++++");

		for(int i=number; i<number+99; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nTask "+ number +" Done+++++++++++++++");
	}
}


class Task1 extends Thread{
	public void run() {
		System.out.println("Task1 starts");

		for(int i=0; i<100; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nTask1 Done");
	}
}

class Task2 implements Runnable{

	@Override
	public void run() {
		System.out.println("Task2 starts");
		
		for(int i=8000; i<8100; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nTask2 Done");
	}

}