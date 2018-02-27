package cn.xingoo.learn.nio;

import io.netty.buffer.ByteBuf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest2 {
    public static void main(String[] args) throws IOException {
        String file = "/Users/xingoo/IdeaProjects/JDK-Learning/src/cn/xingoo/learn/nio/to.txt";
        RandomAccessFile rFile = new RandomAccessFile(file,"rw");
        FileChannel fileCHannel = rFile.getChannel();
        String newData = "new data";
        ByteBuffer buf = ByteBuffer.allocate(20);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();

        // 无法保证一次写入多少buffer，需要循环写入
        while(buf.hasRemaining()){
            fileCHannel.write(buf);
        }
        System.out.println(fileCHannel.size());

        //截取6位
        fileCHannel.truncate(6);
        //强制刷新到磁盘
        fileCHannel.force(true);

        fileCHannel.close();
    }
}
