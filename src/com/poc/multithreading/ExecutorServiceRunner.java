package com.poc.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {
	public static void main(String[] args) {
		// Use following code to maintain only one thread in executor
		/*
		 * ExecutorService executorService = Executors.newSingleThreadExecutor();
		 * executorService.execute(new Task1()); executorService.execute(new Thread(new
		 * Task2()));
		 * 
		 * executorService.shutdown();
		 */
		
		ExecutorService executorServiceFixed = Executors.newFixedThreadPool(2);
		executorServiceFixed.execute(new Task(1));
		executorServiceFixed.execute(new Task(2));
		executorServiceFixed.execute(new Task(50));
		executorServiceFixed.execute(new Task(2000));
		executorServiceFixed.shutdown();
	}
}
