package cn.xingoo.jdk.nio;

import io.netty.channel.socket.SocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class ServerSocketChannelTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);

        while(true){
            SocketChannel socketChannel = (SocketChannel) serverSocketChannel.accept();

            if(socketChannel != null){
                // todo
            }
        }

        //serverSocketChannel.close();

    }
}
