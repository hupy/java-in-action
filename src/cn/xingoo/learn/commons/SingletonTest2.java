package cn.xingoo.learn.commons;

/**
 * Created by xxh on 2016/10/19.
 */
public class SingletonTest2 {
    private static SingletonTest2 INSTANCE;
    private SingletonTest2(){
        System.out.println("Singleton2()");
    }
    private String hello(){
        return "hello！";
    }
    public static SingletonTest2 getInstance(){
        return INSTANCE = new SingletonTest2();
    }
    public static void main(String[] args) {
        System.out.println(SingletonTest2.getInstance().hello());
    }
}
