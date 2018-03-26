package cn.xingoo.book.netty2.chap19;

public class CommonCook {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        // 购买出具
        OnlineShopping thread = new OnlineShopping();
        thread.start(); //启动线程
        thread.join();  //等待线程结束

        // 购买食材
        Thread.sleep(2000);
        Shicai shicai = new Shicai();
        System.out.println("第二步：食材就位");

        // 烹饪
        cook(thread.chuju, shicai);
        System.out.println("第三步：烹饪");

        System.out.println("耗时："+(System.currentTimeMillis() - start));
    }

    static class OnlineShopping extends Thread{
        private Chuju chuju;

        @Override
        public void run() {
            System.out.println("第一步：下单");
            System.out.println("第一步：等待送货");
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("第一步：快递送到");
            chuju = new Chuju();
        }
    }

    static void cook(Chuju chuju, Shicai shicai){}
    static class Chuju{}
    static class Shicai{}
}
