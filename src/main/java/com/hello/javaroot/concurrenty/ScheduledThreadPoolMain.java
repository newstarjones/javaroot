package com.hello.javaroot.concurrenty;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledThreadPoolMain {

	public static void main(String[] args) throws Exception {
		ThreadFactory threadFactory = new ThreadFactory() {
			private AtomicInteger ai = new AtomicInteger();

			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setName("Scheduler_Pool" + ai.getAndIncrement());
				return t;
			}
		};

		ScheduledExecutorService pool = Executors.newScheduledThreadPool(4, threadFactory);
		ScheduledFuture<?> schedule = pool.scheduleWithFixedDelay(new Runnable() {
			public void run() {
				System.out.println("The thread execute...");
			}
		}, 1, 1, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		schedule.cancel(false);
//		ScheduledFuture<?> schedule = pool.schedule(new Runnable() {
//			public void run() {
//				System.out.println("The thread execute...");
//			}
//		}, 1, TimeUnit.SECONDS);
//		
	}
}
