package cn.xingoo.learn.commons;

/**
 * Created by xxh on 2016/10/19.
 */
public class SingletonTest {
    public static final SingletonTest INSTANCE = new SingletonTest();
    private SingletonTest(){
        System.out.println("Singleton()");
    }
    private String hello(){
        return "hello！";
    }

    public static void main(String[] args) {
        System.out.println(SingletonTest.INSTANCE.hello());
    }
}
