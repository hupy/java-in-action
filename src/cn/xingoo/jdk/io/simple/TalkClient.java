package cn.xingoo.jdk.io.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TalkClient {
    public static void main(String[] args) {
        try{
            // 创建连接
            Socket socket = new Socket("127.0.0.1",5555);
            // 获得系统输入流
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

            // 获得socket输出流
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            // 获得socket输入流
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            String readline = sin.readLine();
            while(!readline.equals("bye")){
                os.println(readline);
                os.flush();
                System.out.println("client:"+readline);
                System.out.println("server:"+is.readLine());
                readline = sin.readLine();
            }
            os.close();
            is.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
