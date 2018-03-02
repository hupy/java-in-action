package cn.xingoo.learn.io;

import java.io.*;

public class BufferedStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/xingoo/IdeaProjects/JDK-Learning/src/cn/xingoo/learn/io/a.txt";
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(path));
        DataInputStream input2 = new DataInputStream(new FileInputStream(path));

    }
}
