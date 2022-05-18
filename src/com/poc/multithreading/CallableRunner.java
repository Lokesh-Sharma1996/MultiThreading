package com.poc.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableTask implements Callable<String>{
	
	private String str;

	public CallableTask(String str) {
		this.str = str;
	}
	
	@Override
	public String call() throws Exception {
		System.out.println("call");
		Thread.sleep(1000);
		return str;
	}
	
}

public class CallableRunner {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> submit = executorService.submit(new CallableTask("Hi Java!"));
		System.out.println("After callback task submit");
		
		String msg = submit.get();
		System.out.println(msg);
		
		executorService.shutdown();
	}
}
