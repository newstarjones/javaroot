package com.hello.javaroot.concurrenty;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchMain {
	public static CountDownLatch latch = new CountDownLatch(1);
	public static void main(String[] args) {
		try {
			Thread t = new Thread(new MyTask(latch));
			t.start();
			latch.await();
			System.out.println("MAIN-THRED stop successfully....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static class MyTask implements Runnable {
		private CountDownLatch latch;
		public MyTask(CountDownLatch latch) {
			this.latch = latch;
		}
		public void run() {
			System.out.println("run ok.");
			latch.countDown();
		}
	}
}
