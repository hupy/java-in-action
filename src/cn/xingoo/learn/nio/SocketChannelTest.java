package cn.xingoo.learn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 创建SocketChannel的方式：
 * 1 打开SocketChannel
 * 2 链接ServerSocketChannel
 */
public class SocketChannelTest {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://jenkov.com",80));

        // 读数据
        ByteBuffer readBuffer = ByteBuffer.allocate(48);
        int bytesRead = socketChannel.read(readBuffer);

        // 写数据
        String newData = "hello new data";
        ByteBuffer writeBuffer = ByteBuffer.allocate(48);
        writeBuffer.clear();
        writeBuffer.put(newData.getBytes());
        writeBuffer.flip();
        while(writeBuffer.hasRemaining()){
            socketChannel.write(writeBuffer);
        }

        // 设置非阻塞
        socketChannel.configureBlocking(false);
        while(!socketChannel.finishConnect()){
            // wait or something
        }

        socketChannel.close();
    }
}
