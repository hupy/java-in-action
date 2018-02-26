package cn.xingoo.learn.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * capacity buffer的容量
 * position 操作的位置，写入的位置以及读取的位置
 * limit 写模式下，为最多写入的量；读模式下，为当前position
 */
public class BufferTest {
    public static void main(String[] args) throws IOException {
        String file = "/Users/xingoo/IdeaProjects/JDK-Learning/src/cn/xingoo/learn/nio/test.txt";
        RandomAccessFile accessFile = new RandomAccessFile(file,"rw");
        FileChannel fileChannel = accessFile.getChannel();
        // 20个字节
        ByteBuffer buffer = ByteBuffer.allocate(20);
        int bytesRead = fileChannel.read(buffer);
        // buffer.put()也能写入buffer
        while(bytesRead!=-1){
            // 写切换到读
            buffer.flip();

            while(buffer.hasRemaining()){
                System.out.println((char)buffer.get());
            }

            // buffer.rewind()重新读
            // buffer.mark()标记position buffer.reset()恢复

            // 清除缓冲区
            buffer.clear();
            // buffer.compact(); 清楚读过的数据
            bytesRead = fileChannel.read(buffer);
        }
    }
}
