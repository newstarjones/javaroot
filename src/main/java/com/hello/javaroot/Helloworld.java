package com.hello.javaroot;

import sun.misc.Unsafe;

public class Helloworld {
	 private static final Unsafe unsafe = Unsafe.getUnsafe();
	   private long myCountAddress = 10L;
	   public int getCount() { return unsafe.getByte(myCountAddress); }
	   public static void main(String[] args) {
		
	}

}
