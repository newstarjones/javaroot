package com.hello.javaroot.util;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

public class ArrayBlockingQueueTest {
	
	@Test
	public void testAdd() {
		Queue<String> queue = new ArrayBlockingQueue<String>(2);
		queue.add("111");
		queue.add("112");
		queue.add("113");
	}

}
