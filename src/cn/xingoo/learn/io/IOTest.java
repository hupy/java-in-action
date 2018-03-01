package cn.xingoo.learn.io;

import java.io.*;

public class IOTest {
    // 数据媒介：
    // 文件、管道、网络连接、内存缓存、System.in out error
    public static void main(String[] args) throws IOException {

        // 字节输入流操作
        InputStream input = new ByteArrayInputStream("abcd".getBytes());
        int data = input.read();
        while(data != -1){
            System.out.println((char)data);
            data = input.read();
        }

        // 字符输入流操作
        Reader reader = new CharArrayReader("abcd".toCharArray());
        data = reader.read();
        while(data != -1){
            System.out.println((char)data);
            data = reader.read();
        }

        // 字节输出流
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write("12345".getBytes());
        byte[] ob = output.toByteArray();

        // 字符输出流
        CharArrayWriter writer = new CharArrayWriter();
        writer.write("12345".toCharArray());
        char[] wc = writer.toCharArray();
    }
}
