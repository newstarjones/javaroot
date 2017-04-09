package sun;

import java.nio.ByteBuffer;

import org.junit.Test;

import sun.nio.ch.DirectBuffer;

/**
 * DirectByteBuffer �÷�.
 * 
 * Netty֮Java�����ڴ�ɨä��
 * http://calvin1978.blogcn.com/articles/directbytebuffer.html
 * 
 * DirectByteBuffer
 * http://blog.sina.com.cn/s/blog_bd5db8370102vzm8.html
 * 
 * 
 * Ҫ�㣺 
 * 		 1	���� -XX:MaxDirectMemorySize �������ƶ����ڴ�Ĵ�С���������ڴ�ﵽ�ô�Сʱ����full gc. ��������ڴ���߼��ǣ��Ƿ����㹻�ڴ�ɷ��䣬û�У�
 * 			����gc���ȴ�100ms�� �ٴ����룬��Ч�׳�OOM����Bits.reserveMemory()����.
 * 		 2	DirectByteBuffer�����ö������ڶ��У��������պ���ͨ�����һ�����������ö��󱻻���ʱ��Ӧ���ڴ�Ҳ�����ա�����������ǣ��������ö���
 * 			����young gc�����old gc����ʱ��old���򲻷���full gc�������õĶ����ڴ潫�����ͷ�.�⵼�����������1�еĲ�������Ҳ��100%���ף����
 * 			������Լ��������ն����ڴ�
 * 		 3	
 * 
 * ������Ҫ�ѷ���
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
