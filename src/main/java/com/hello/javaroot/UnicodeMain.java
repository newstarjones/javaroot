package com.hello.javaroot;

import java.nio.charset.Charset;

public class UnicodeMain {

	public static void main(String[] args) throws Exception {
		String s = "˼��";
		System.out.println("��ǰ�����ʵ����Ĭ���ַ����룺" + Charset.defaultCharset());
	}

}
