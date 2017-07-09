package com.hello.javaroot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//分布式事务
//http://www.infoq.com/cn/articles/solution-of-distributed-system-transaction-consistency
//http://weibo.com/ttarticle/p/show?id=2309403965965003062676/*
/**
 * 蚂蚁金服风控部 面试题
 * @author Administrator
 *
 */
public class AliMianShiMain2 {

	public static List<String> list = new ArrayList<String>();
	
	static {
		for(int i=1; i<26; i++) {
			list.add(String.valueOf(i));
		}
	}
	
	public static void main(String[] args) {
		String str = "13245";
		// 13 2 4 5  
		// 13 24 5
		// 1 3 24 5
		// 1 3 2 4 5 
		int res = computePossibility(str);
		System.out.println(res);
	}


	private static int computePossibility(String str) {
		
		int sum = 0 ;
		if(str.length() == 1) {
			return 1;
		}
		
		if(list.contains(str.substring(0,1))) {
			sum = computePossibility(str.substring(1));
		}
		
		if(str.length() == 2 && list.contains(str)) {
			sum++;
		}
		
		
		if(str.length() > 2 && list.contains(str.substring(0,2))) {
			sum += (computePossibility(str.substring(2)));
		}
		
		return sum;
	}}

