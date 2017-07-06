package com.hello.javaroot.concurrenty;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 一个主线程下有多个子线程任务，主线程必须在100秒内将子线程执行的集合结果进行处理返回 子线程如果在100秒内没有执行完停止执行
 * 
 * @author Administrator
 *
 */
public class ExecuteInSpecifiedTime {
	// 开启多少个子线程
	private static final int THREAD_COUNT = 2;
	private static final int THREAD_TIMEOUT = 5;

	public static void main(String[] args) {
		way1();
	}

	/**
	 * 采用线程池的awaitTermination方法.
	 * 
	 */
	public static void way1() {
		ExecutorService pool = Executors.newCachedThreadPool();
		Callable<List<String>> c1 = new Callable<List<String>>() {
			@Override
			public List<String> call() throws Exception {
				boolean flag = true;
				while(flag) {
					
				}
				return null;
			}

		};
		pool.submit(c1);
		try {
			boolean result = pool.awaitTermination(THREAD_TIMEOUT, TimeUnit.SECONDS);
			if(result) {
				// 执行完毕 交由主线程执行
				System.out.println("Main Thread executing success ...");
				c1.call();
			}
			else {
				System.out.println("Sub Thread can not execute in "+ THREAD_TIMEOUT + " s ...");
			}
			// TODO 无法关闭死循环的线程
			pool.shutdownNow();
		} catch (Exception e) {
			// 100s还没执行完
			e.printStackTrace();
		}
	}

	private static CountDownLatch cdl = new CountDownLatch(THREAD_COUNT);

	/**
	 * 采用 CountDownLatch的await超时方法.
	 * 
	 */
	public static void way2() {
		ExecutorService pool = Executors.newCachedThreadPool();
		Callable<List<String>> c1 = new Callable<List<String>>() {
			@Override
			public List<String> call() throws Exception {
				cdl.countDown();
				return null;
			}

		};
		pool.submit(c1);

		try {
			boolean result = cdl.await(THREAD_TIMEOUT, TimeUnit.SECONDS);
			if(result) {
				System.out.println("Main Thread executing success ...");
				// 合并sub thread 结果
			}
			else {
				// 超时 子线程在指定时间内未完成
				System.out.println("Sub Thread can not execute in "+ THREAD_TIMEOUT + " s ...");
			}
			pool.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
