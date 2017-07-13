package com.hello.javaroot.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * 参考page139
 * 
 * @author Administrator
 *
 */
public class MyServer {

	public static void main(String[] args) {
		try {
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false);
			serverChannel.socket().bind(new InetSocketAddress(12346));
			
			Selector selector = Selector.open();
//			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			
			serverChannel.register(selector, serverChannel.validOps());
			while(true) {
				if(selector.select() > 0) {
					Set<SelectionKey> selectedKeys = selector.selectedKeys();
					for(SelectionKey k : selectedKeys) {
						selectedKeys.remove(k);
						if(!k.isValid()) {
							continue;
						}
						if(k.isAcceptable()) {
							SocketChannel channel = ((ServerSocketChannel)k.channel()).accept();
							channel.configureBlocking(false);
							ByteBuffer buf = ByteBuffer.allocateDirect(1024);
							channel.register(selector, SelectionKey.OP_READ, buf);
						}
						if(k.isReadable()) {
							SocketChannel channel = (SocketChannel)k.channel();
							ByteBuffer buf = (ByteBuffer)k.attachment();
							int count = channel.read(buf);  // 注意这里的channel的数据读取方式
							if(count < 0) {
								
							}
						}
					}
				};
			}
			
//			server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
