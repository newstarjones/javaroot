package com.hello.javaroot;

import java.nio.charset.Charset;

public class UnicodeMain {

	public static void main(String[] args) throws Exception {
		String s = "思考";
		System.out.println("当前虚拟机实例的默认字符编码：" + Charset.defaultCharset());
	}

}
