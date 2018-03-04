package cn.xingoo.learn.net.simple;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {
    public static void main(String[] args) {
        try{
            // 创建ServerSocket
            ServerSocket server= new ServerSocket(5555);
            // 阻塞并等待连接
            Socket socket = server.accept();
            // 获得对应的输入流
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            // 获得对应的输出流
            PrintWriter print = new PrintWriter(socket.getOutputStream());

            String line = is.readLine();
            while(!"bye".equals(line)){
                // 回应ok
                print.println("ok");
                print.flush();
                System.out.println("client:"+line);

                line = is.readLine();
            }
            print.close();
            is.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
