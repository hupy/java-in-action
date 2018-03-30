package cn.xingoo.jdk.io;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        String path = "/Users/xingoo/IdeaProjects/JDK-Learning/src/cn/xingoo/learn/io/a.txt";
        File file = new File(path);
        System.out.println("文件是否存在："+file.exists());
        System.out.println("文件长度："+file.length());
        //file.renameTo(new File("/Users/xingoo/IdeaProjects/JDK-Learning/src/cn/xingoo/learn/io/a.txt"));
        String[] fileNames = new File("/Users/xingoo/IdeaProjects/JDK-Learning/src/cn/xingoo/learn/io").list();
        for(String f : fileNames){
            System.out.println(f);
        }
    }
}
