package cn.xingoo.book.zook.other;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(()->{
            System.out.println("进入线程A");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A:线程A结束");
        });
        A.start();

        System.out.println("Main:等待线程A结束");
        A.join();
        System.out.println("Main:线程A已经结束，退出");
    }
}
