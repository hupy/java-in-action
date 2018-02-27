package cn.xingoo.learn.nio.example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelThread implements Runnable{
    private SocketChannel socketChannel;
    private String remoteName;

    public SocketChannelThread(SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        this.remoteName = socketChannel.getRemoteAddress().toString();
        System.out.println("client " + remoteName + " 连接成功");
    }

    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(20);

        while(true){
            try {
                buffer.clear();
                int read = socketChannel.read(buffer);
                if(read != -1){
                    StringBuilder sb = new StringBuilder();
                    buffer.flip();
                    while(buffer.hasRemaining()){
                        sb.append((char)buffer.get());
                    }
                    System.out.println(remoteName+":"+sb.toString());
                }
            } catch (IOException e) {
                try {
                    socketChannel.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
