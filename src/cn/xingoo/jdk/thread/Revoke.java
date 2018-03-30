package cn.xingoo.jdk.thread;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Revoke {
    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String s="A";
        Class clazz =Revoke.class;
        Method method =clazz.getMethod(s);
        method.invoke(clazz.newInstance());
    }

    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Stu st1 = new Stu("zhangsan");
        Class clazz = st1.getClass();
        Method method = clazz.getMethod("test");
        method.invoke(st1);
    }

    public void A(){
        System.out.println("方法A执行了");
    }

    class Stu{
        public String name;
        public Stu(){}
        public Stu(String name){
            this.name = name;
        }
        public void test(){
            System.out.println("my name is "+name);
        }
    }

}
