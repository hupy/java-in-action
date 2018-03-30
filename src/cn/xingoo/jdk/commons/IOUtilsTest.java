package cn.xingoo.jdk.commons;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xxh on 2016/10/19.
 */
public class IOUtilsTest {
    @Test
    public void skipTest(){
        InputStream is = IOUtils.toInputStream("hello world");
        try {
            IOUtils.skip(is,4);
            System.out.println(IOUtils.toString(is,"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void skipFullyTest(){
        InputStream is = IOUtils.toInputStream("hello world");
        try {
            IOUtils.skipFully(is,30);
            System.out.println(IOUtils.toString(is,"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeTest(){
        try {
            OutputStream os = new FileOutputStream("E:/test.txt");
            IOUtils.write("hello write!",os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeLinesTest() throws IOException {
        List<String> lines = new ArrayList();
        lines.add("hello");
        lines.add("list");
        lines.add("to");
        lines.add("file");
        OutputStream os = new FileOutputStream("E:/test.txt");
        IOUtils.writeLines(lines,IOUtils.LINE_SEPARATOR,os);
    }

    @Test
    public void contentEqualsTest(){
        InputStream is1 = IOUtils.toInputStream("hello123");
        InputStream is2 = IOUtils.toInputStream("hello123");

        try {
            System.out.println(IOUtils.contentEquals(is1,is2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
