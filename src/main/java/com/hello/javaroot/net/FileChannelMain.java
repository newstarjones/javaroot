package com.hello.javaroot.net;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelMain {

	public static void main(String[] args) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("a.txt");
			FileChannel channel = fos.getChannel();
			ByteBuffer buf = ByteBuffer.allocateDirect(1024);
			
			buf.put("1234567".getBytes());
			buf.flip();
			byte[] dst = new byte[1];
			buf.get(dst);
			System.out.println(buf.position());
			buf.compact();
			System.out.println(buf.position());
			System.out.println((char)buf.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
