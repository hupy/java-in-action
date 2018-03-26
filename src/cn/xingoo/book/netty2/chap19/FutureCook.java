package cn.xingoo.book.netty2.chap19;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureCook {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        // 另一种Runnable，可以有返回值，可以抛出异常
        Callable<Chuju> onlineShopping = new Callable<Chuju>() {
            @Override
            public Chuju call() throws Exception {
                System.out.println("第一步：下单");
                System.out.println("第一步：等待送货");
                Thread.sleep(5000);
                System.out.println("第一步：快递送到");
                return new Chuju();
            }
        };

        FutureTask<Chuju> task = new FutureTask<Chuju>(onlineShopping);
        new Thread(task).start();

        // 买食材
        Thread.sleep(2000);
        System.out.println("第二步：食材到位");

        if(!task.isDone()){
            System.out.println("抱怨....还没到...");
        }

        // 等厨具
        Chuju chuju = task.get();
        System.out.println("第三步：厨具到位");

        cook();
        System.out.println("第四步：做饭");
        System.out.println("耗时："+(System.currentTimeMillis() - start));
    }

    static void cook(){}

    static class Chuju{}
    static class Shicai{}
}
