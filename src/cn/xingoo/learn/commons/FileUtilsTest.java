package cn.xingoo.learn.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * FileUtils支持很多文件操作，如
 *
 * 文件写入
 * 读取文件
 * 创建目录
 * 拷贝文件和目录
 * 删除文件和目录
 * 从URL转换
 * 基于统配和过滤查看文件和目录
 * 比较文件内容
 * 文件的更新时间
 * 检查校验码
 *
 * Created by xxh on 2016/11/24.
 */
public class FileUtilsTest {
    private static File parent = new File("D://test");
    @Test
    public void getDirTest(){
        //获得基本的信息
        System.out.println(FileUtils.getTempDirectory());//获取临时目录 java.io.tmpdir,getUserDirectoryPath返回路径字符串
        System.out.println(FileUtils.getUserDirectory());//获取用户主目录 user.home,getUserDirectoryPath返回路径字符串

        //以可读的方式，返回文件的大小EB, PB, TB, GB, MB, KB or bytes
        System.out.println(FileUtils.byteCountToDisplaySize(10000000));
        System.out.println(FileUtils.byteCountToDisplaySize(1));
    }

    @Test
    public void openStream() throws IOException {
        //获取文件输入和输出的文件流
        //文件是目录或者不存在，都会跑出异常
        InputStream in = FileUtils.openInputStream(new File("D://test/test1"));
        OutputStream out = FileUtils.openOutputStream(new File("D://test/test2"));
        out = FileUtils.openOutputStream(new File("D://test/test3"),true);//是否追加的形式添加内容
    }

    @Test
    public void FileOperation() throws IOException {
        //创建文件，如果文件存在则更新时间；如果不存在，创建一个空文件
        //创建空文件的方式为：
        // final OutputStream out = openOutputStream(file);
        // IOUtils.closeQuietly(out);
        FileUtils.touch(new File("D://test/test4"));

        //文件内容的对比
        FileUtils.contentEquals(new File("D://test/test1"),new File("D://test/test2"));
        FileUtils.contentEqualsIgnoreEOL(new File("D://test/test1"),new File("D://test/test2"),null);//忽略换行符，第三个参数是字符集

        //根据URL获取文件
        FileUtils.toFile(new URL("file://D://test/test1"));
        FileUtils.toFiles(null);
        FileUtils.toURLs(new File[]{new File("D://test/test1")});

        //文件拷贝
        FileUtils.copyFileToDirectory(new File("/test1"),new File("/dir"),true);//第三个参数是否更新时间
        FileUtils.copyFile(new File("/source"),new File("/target"),true);//TODO 阅读doCopy源码

        //目录拷贝
        File srcDir = new File("/source");
        File destDir = new File("/target");

        FileUtils.copyDirectoryToDirectory(new File("/source"),new File("/target"));
        FileUtils.copyDirectory(new File("/source"),new File("/target"));

        FileUtils.copyDirectory(srcDir, destDir, DirectoryFileFilter.DIRECTORY);//仅仅拷贝目录

        IOFileFilter txtSuffixFilter = FileFilterUtils.suffixFileFilter(".txt");// 创建.txt过滤器
        IOFileFilter txtFiles = FileFilterUtils.andFileFilter(FileFileFilter.FILE, txtSuffixFilter);
        // 创建包含目录或者txt文件的过滤器
        FileFilter filter = FileFilterUtils.orFileFilter(DirectoryFileFilter.DIRECTORY, txtFiles);
        // Copy using the filter
        FileUtils.copyDirectory(srcDir, destDir, filter);//TODO 阅读doCopyDirectory源码

        //文件拷贝
        FileUtils.copyInputStreamToFile(new FileInputStream("/test"),new File("/test"));
        FileUtils.copyURLToFile(new URL("file:/test"),new File("/test"));

        //删除文件
        FileUtils.deleteDirectory(new File("/test"));//删除目录下所有的内容
        FileUtils.deleteQuietly(new File("/test"));//如果是目录，会级联删除；不会抛出异常

        //判断文件是否存在
        FileUtils.directoryContains(new File("/dir"),new File("/file"));

        //清除目录中的内容
        FileUtils.cleanDirectory(new File("/dir"));//TODO verifiedListFiles  <------2016/11/24
    }

    @Test
    public void findFiles(){
        //返回文件的列表
        List<File> files = (List<File>) FileUtils.listFiles(parent,new String[]{"test1","test2"},true);//TODO 重点看一下源码

        //返回文件迭代器
        Iterator<File> files_iter =  FileUtils.iterateFiles(parent,new String[]{"test1","test3"},true);

        //把collection<File>转换成File[]
        FileUtils.convertFileCollectionToFileArray(files);
    }
}
