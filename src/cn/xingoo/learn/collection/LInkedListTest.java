package cn.xingoo.learn.collection;

import org.junit.Test;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LInkedListTest {

    @Test
    public void stackTest(){
        Deque<String> stack = new LinkedList<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.forEach(System.out::println);
        System.out.println("---------------------");

        System.out.println("出栈:"+stack.pop());
        stack.forEach(System.out::println);
        System.out.println("---------------------");

        stack.push("4");
        stack.forEach(System.out::println);
    }

    @Test
    public void queueTest(){
        Deque<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.forEach(System.out::print);
        System.out.println();
        System.out.println(queue.peek());//不会删除元素
        queue.forEach(System.out::print);
        System.out.println();
        System.out.println(queue.poll());//删除元素
        queue.forEach(System.out::print);
        System.out.println();
        System.out.println(queue.pollLast());//先进后出
        queue.forEach(System.out::print);
        System.out.println();
    }

    @Test
    public void iteratorTest(){
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iter = list.iterator();

        // throws Exception java.util.ConcurrentModificationException
        while(iter.hasNext()){
            System.out.println(iter.next());
            list.remove(0);
        }
    }
}
