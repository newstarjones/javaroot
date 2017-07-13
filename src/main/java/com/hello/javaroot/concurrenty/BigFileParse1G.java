package com.hello.javaroot.concurrenty;

import java.util.concurrent.locks.LockSupport;

/**
 * 1G日志文件，每行大小17K，内存1M，请统计出现次数排名前3的词
 * 
 * @author Administrator
 *
 */
public class BigFileParse1G {

	// 1G分为 1024的1M的内存段 
	
	public static void main(String[] args) {
		int a ;
		LockSupport.park(new BigFileParse1G());
		System.out.println(a = 3);
	}
	
}
