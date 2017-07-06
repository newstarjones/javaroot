package com.hello.javaroot.concurrenty;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A B C ���߳�����ִ������.
 * 
 * ��һ���뷨�� ʹ�� join��֤ABC˳��Ȼ��ABC ͬ��һ��MAP��MAP�������ABC��ִ��״̬, 0 δִ�У� 1 ��ʾִ��
 * 
 * @author Administrator
 *
 */
public class A_B_C_Threads {
	
	private static ReentrantLock lock = new ReentrantLock();
	
	private static Condition a = lock.newCondition();
	private static Condition b = lock.newCondition();
	private static Condition c = lock.newCondition();

	public static void main(String[] args) {
		Thread A = new Thread(new Runnable() {

			@Override
			public void run() {
				lock.lock();
				try {
					while(true) {
						c.await();
						System.out.println("A");
						a.signal();
					}
				} catch(InterruptedException e) {
					
				} finally {
					lock.unlock();
				}
				
			}});
		
		Thread B = new Thread(new Runnable() {

			@Override
			public void run() {
				lock.lock();
				try {
					while(true) {
						a.await();
						System.out.println("B");
						b.signal();
					}
				} catch(InterruptedException e) {
					
				} finally {
					lock.unlock();
				}
				
			}});
		
		
		Thread C = new Thread(new Runnable() {

			@Override
			public void run() {
				lock.lock();
				try {
					while(true) {
						b.await();
						System.out.println("C");
						c.signal();
					}
				} catch(InterruptedException e) {
					
				} finally {
					lock.unlock();
				}
				
			}});
		
		A.start();
		B.start();
		C.start();
		
		// ���̴߳���A�̵߳�����.
		lock.lock();
		try {
			c.signal();
		}finally {
			lock.unlock();
		}
	}
	
	
	
}
