package com.hello.javaroot.zzm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * <p> 
 * 堆空间溢出
 * 
 * @author Administrator
 *
 */
public class HeapOOM {

	static class OOMObject {
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true) {
			list.add(new OOMObject());
		}
	}
}
