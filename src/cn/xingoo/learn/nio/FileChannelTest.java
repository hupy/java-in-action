package cn.xingoo.learn.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        String file = "/Users/xingoo/IdeaProjects/JDK-Learning/src/cn/xingoo/learn/nio/test.txt";
        // 创建文件
        RandomAccessFile accessFile = new RandomAccessFile(file,"rw");
        // 创建channel
        FileChannel inChannel = accessFile.getChannel();
        // 创建buffer，并设置buffer的大小
        ByteBuffer buf = ByteBuffer.allocate(20);
        // 从channel中读取数据到buffer
        int bytesRead = inChannel.read(buf);
        while(bytesRead != -1){
            System.out.println("read "+ bytesRead);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.println((char)buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        accessFile.close();
    }
}
