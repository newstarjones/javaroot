package com.hello.javaroot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 蚂蚁金服风控部 面试题
 * 下面的解法是错误的
 * @author Administrator
 *
 */
public class AliMianShiMain {

	public static void main(String[] args) {
	}
}
//	public static Map map = new HashMap(); // 这个map放入所有1-a 2-b .. 26-z 的映射
//	public static List list = new ArrayList();
//	static {
//		for(int i=1; i<=26; i++) {
//			map.put(String.valueOf(i), String.valueOf((97+i)));
//			list.add(String.valueOf(i));
//		}
//		
//		
//	}
//
//	public static void main(String[] args) {
//
//		String str1 = "123"; // 任意数字组合
//		// set = {1,..26}
//		long result = 0;
//
//		for (int i = 0; i <= str1.length(); i++) {
//			result += computePossability(str1, i);
//		}
//		System.out.println(result);
//		
//		
//	}
//
//	static long computePossability(String str, int i) {
//		long result = 0;
//		if (i < str.length() && map.containsKey(str.substring(i, i + 1))) {
//			result += 1;
//		}
//
//		if(i == str.length() && map.containsKey(str.substring(i))) {
//			result += 1;
//		}
//		
//		if (i == str.length() - 1 && map.containsKey(str.substring(i))) {
//			result += 1;
//		}
//		
//		if(i < str.length() - 1 && map.containsKey(str.substring(i))) {
//			result += 1;
//		}
//		
//		return result;
//	}
//}

