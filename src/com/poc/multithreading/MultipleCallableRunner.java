package com.poc.multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		List<CallableTask> tasks = List.of(new CallableTask("Hi C"),
										   new CallableTask("Hi C++"),
										   new CallableTask("Hi Java"));
		
		List<Future<String>> result = executorService.invokeAll(tasks);
		for(Future<String> f: result) {
			System.out.println(f.get());
		}
		
		executorService.shutdown();
	}
}
