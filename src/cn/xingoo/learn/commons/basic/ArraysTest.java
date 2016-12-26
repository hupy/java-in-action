package cn.xingoo.learn.commons.basic;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by xxh on 2016-12-26.
 */
public class ArraysTest {
    String[] array = new String[]{"a","c","2","1","b"};
    Integer[] ints = new Integer[]{5,1,4,3,2};

    @Test
    public void test1(){
        List<String> lists = Arrays.asList(array);
    }

    /**
     * 测试排序
     */
    @Test
    public void sort(){
       /* Arrays.sort(array);
        for(String str : array){
            System.out.println(str);
        }*/
        Arrays.sort(array,2,5);
        System.out.println(Arrays.deepToString(array));//[a, c, 1, 2, b]
    }

    @Test
    public void binarySearch(){
        //binarySearch需要保证是排好序的
        System.out.println(Arrays.binarySearch(array,"c"));//-6
        Arrays.sort(array);
        System.out.println(Arrays.binarySearch(array,"c"));//4
    }

    @Test
    public void copyOf(){
        //如果位数不够，需要补位
        Integer[] result = Arrays.copyOf(ints,10);
        for(int i : result){
            System.out.println(i);
        }
        System.out.println("----------------------------------------->");
        //如果位数够，就取最小的数组
        result = Arrays.copyOf(ints,3);
        for(int i : result){
            System.out.println(i);
        }
        System.out.println("----------------------------------------->");
        //
        result = Arrays.copyOfRange(ints,2,4);
        for(int i : result){
            System.out.println(i);
        }
    }

    @Test
    public void deepTest(){
        String[] array2 = new String[]{"a","c","2","1","b"};
        System.out.println(Arrays.deepEquals(array,array2));//深度比较两个数组是否相同

        System.out.println(Arrays.deepHashCode(array));
        System.out.println(Arrays.deepHashCode(array2));//如果两个数组deepEquals，那么他们的hashcode一定相同

        //格式化输出数组
        System.out.println(Arrays.deepToString(array));
    }

    @Test
    public void equals(){
        String[] array2 = new String[]{"a","c","2","1","b"};

        //1 对比引用是否相同
        //2 对比是否存在null
        //3 对比长度是否相同
        //4 挨个元素对比
        System.out.println(Arrays.equals(array,array2));
    }

    @Test
    public void fill(){
        Arrays.fill(array,"test");
        System.out.println(Arrays.deepToString(array));
    }

    @Test
    public void string(){
        System.out.println(Arrays.toString(array));//[a, c, 2, 1, b]
    }

    @Test
    public void toStream(){
        Arrays.stream(array).forEach(s-> System.out.println(s));
    }

    @Test
    public void parallelSort(){
        //看着没啥作用
        Date start = new Date();
        int[] numbers = new int[500000];
        for(int i=0;i<500000;i++){
            numbers[i] = new Random().nextInt(100);
        }
        Arrays.sort(numbers);
        Date end = new Date();
        System.out.println(end.getTime()-start.getTime());

        start = new Date();
        for(int i=0;i<500000;i++){
            numbers[i] = new Random().nextInt(100);
        }
        Arrays.parallelSort(numbers);
        end = new Date();
        System.out.println(end.getTime()-start.getTime());
    }

    @Test
    public void parallelPrefix(){
        Arrays.parallelPrefix(ints,(x,y)->(x+y));
        System.out.println(Arrays.deepToString(ints));//[5, 6, 10, 13, 15]
    }

    @Test
    public void parallelSetAll(){
        Arrays.parallelSetAll(ints,x->x*x);
        System.out.println(Arrays.toString(ints));//[0, 1, 4, 9, 16]
    }

    @Test
    public void setAll(){
        Arrays.setAll(ints,x->x*2);
        System.out.println(Arrays.toString(ints));
    }

}
