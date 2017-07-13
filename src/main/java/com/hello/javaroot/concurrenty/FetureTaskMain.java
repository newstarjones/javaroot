package com.hello.javaroot.concurrenty;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FetureTaskMain {

	public static void main(String[] args) throws Exception {
		Runnable run = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("123");
			}};
//		Thread t = new Thread(run);
//		t.start();
//		
//		t.join();
		
		FutureTask<Boolean> ft = new FutureTask<Boolean>(run , true);
		ft.run();
		
		Boolean boolean1 = ft.get(1, TimeUnit.SECONDS);
		System.out.println(boolean1);
	}

}
