package cn.xingoo.learn.nio.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor excutor = new ThreadPoolExecutor(
                3,
                10,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(100)
        );

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(12345));
        //serverSocketChannel.configureBlocking(false);

        while(true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            if(socketChannel != null){
                System.out.println("接收心情求，启动新线程处理");
                excutor.submit(new SocketChannelThread(socketChannel));
            }
        }
    }
}
