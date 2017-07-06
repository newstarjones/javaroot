package com.hello.javaroot.concurrenty;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * һ�����߳����ж�����߳��������̱߳�����100���ڽ����߳�ִ�еļ��Ͻ�����д����� ���߳������100����û��ִ����ִֹͣ��
 * 
 * @author Administrator
 *
 */
public class ExecuteInSpecifiedTime {
	// �������ٸ����߳�
	private static final int THREAD_COUNT = 2;
	private static final int THREAD_TIMEOUT = 5;

	public static void main(String[] args) {
		way1();
	}

	/**
	 * �����̳߳ص�awaitTermination����.
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
				// ִ����� �������߳�ִ��
				System.out.println("Main Thread executing success ...");
				c1.call();
			}
			else {
				System.out.println("Sub Thread can not execute in "+ THREAD_TIMEOUT + " s ...");
			}
			// TODO �޷��ر���ѭ�����߳�
			pool.shutdownNow();
		} catch (Exception e) {
			// 100s��ûִ����
			e.printStackTrace();
		}
	}

	private static CountDownLatch cdl = new CountDownLatch(THREAD_COUNT);

	/**
	 * ���� CountDownLatch��await��ʱ����.
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
				// �ϲ�sub thread ���
			}
			else {
				// ��ʱ ���߳���ָ��ʱ����δ���
				System.out.println("Sub Thread can not execute in "+ THREAD_TIMEOUT + " s ...");
			}
			pool.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
