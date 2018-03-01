package cn.xingoo.learn.io;

import java.io.*;

public class ReaderAndWriterTest {
    public static void main(String[] args) throws IOException {
        String file = "/Users/xingoo/IdeaProjects/JDK-Learning/src/cn/xingoo/learn/io/a.txt";
        Reader reader = new FileReader(file);
        // inputstream 一次返回一个字节 0-255
        // reader 一次返回一个字符，0-65535，根据文本的编码决定读取几个字节
        int data = reader.read();
        while(data != -1){
            char dataChar = (char) data;
            System.out.println(dataChar);
            data = reader.read();
        }

        Writer writer = new FileWriter("/Users/xingoo/IdeaProjects/JDK-Learning/src/cn/xingoo/learn/io/b.txt");
        writer.write("hello");
        writer.close();
    }
}
