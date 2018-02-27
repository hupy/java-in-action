package cn.xingoo.learn.nio.example;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(12345));
        while(true){
            Scanner sc = new Scanner(System.in);
            String next = sc.next();

            byte[] bytes = next.getBytes("UTF-8");
            int size = bytes.length;
            ByteBuffer buffer = ByteBuffer.allocate(size);
            buffer.put(bytes);

            buffer.flip();

            while( buffer.hasRemaining()){
                socketChannel.write(buffer);
            }

        }
    }
}
