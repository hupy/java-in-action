package cn.xingoo.learn.io;

import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {

        String path = "/Users/xingoo/IdeaProjects/JDK-Learning/src/cn/xingoo/learn/io/a.txt";

        try(RandomAccessFile file = new RandomAccessFile(path,"rw")){
            file.seek(3);
            int data = file.read();
            while(data !=-1){
                System.out.println((char)data);
                data = file.read();
            }
        }catch (Exception e){

        }
    }
}
