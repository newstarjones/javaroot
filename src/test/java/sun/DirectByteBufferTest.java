package sun;

import java.nio.ByteBuffer;

import org.junit.Test;

import sun.nio.ch.DirectBuffer;

/**
 * DirectByteBuffer 用法.
 * 
 * Netty之Java堆外内存扫盲贴
 * http://calvin1978.blogcn.com/articles/directbytebuffer.html
 * 
 * DirectByteBuffer
 * http://blog.sina.com.cn/s/blog_bd5db8370102vzm8.html
 * 
 * 
 * 要点： 
 * 		 1	设置 -XX:MaxDirectMemorySize 参数控制堆外内存的大小，当堆外内存达到该大小时触发full gc. 分配堆外内存的逻辑是：是否有足够内存可分配，没有，
 * 			发起gc，等待100ms， 再次申请，无效抛出OOM，见Bits.reserveMemory()方法.
 * 		 2	DirectByteBuffer的引用对象存放在堆中，垃圾回收和普通对象的一样，当该引用对象被回收时对应的内存也被回收。这里的问题是，当该引用对象
 * 			熬过young gc后进入old gc，此时若old区域不发生full gc，则引用的堆外内存将不会释放.这导致最好是设置1中的参数，但也不100%靠谱，因此
 * 			最好是自己主动回收堆外内存
 * 		 3	
 * 
 * 两个重要堆分类
 * 		HeapByteBuffer
 * 		DirectByteBuffer
 * 
 * @author Administrator
 *
 */
public class DirectByteBufferTest {
	
	@Test
	public void testClearDirectBuffer() {
		ByteBuffer bb = ByteBuffer.allocateDirect(1024);
		bb.put((byte)1);
		DirectBuffer allocateDirect = (DirectBuffer)bb;
		allocateDirect.cleaner().clean();
	}
	
}
