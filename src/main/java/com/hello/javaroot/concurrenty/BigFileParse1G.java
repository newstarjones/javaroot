package com.hello.javaroot.concurrenty;

import java.util.concurrent.locks.LockSupport;

/**
 * 1G��־�ļ���ÿ�д�С17K���ڴ�1M����ͳ�Ƴ��ִ�������ǰ3�Ĵ�
 * 
 * @author Administrator
 *
 */
public class BigFileParse1G {

	// 1G��Ϊ 1024��1M���ڴ�� 
	
	public static void main(String[] args) {
		int a ;
		LockSupport.park(new BigFileParse1G());
		System.out.println(a = 3);
	}
	
}
