package cn.xingoo.jdk.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelTransport {
    public static void main(String[] args) throws IOException {
        String from = "/Users/xingoo/IdeaProjects/JDK-Learning/src/cn/xingoo/learn/nio/from.txt";
        String to   = "/Users/xingoo/IdeaProjects/JDK-Learning/src/cn/xingoo/learn/nio/to.txt";

        RandomAccessFile fromFile = new RandomAccessFile(from,"rw");
        RandomAccessFile toFile   = new RandomAccessFile(to,"rw");

        FileChannel fromChannel = fromFile.getChannel();
        FileChannel toChannel   = toFile.getChannel();

        long position = 0;
        long count    = fromChannel.size();

        //toChannel.transferFrom(fromChannel, position, count);
        fromChannel.transferTo(position, count, toChannel);

        fromFile.close();
        toFile.close();
    }
}
