package cn.xingoo.test.basic.thread;

public class AnimalEat {

    public static void main(String[] args) {
        System.out.println("盆里有20块肉");
        Animal animal = new Animal();
        try{
            Thread tidy = new Thread(animal,"泰迪");
            Thread cat  = new Thread(animal,"美短");
            tidy.start();
            cat.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("盆里的肉吃完了！");
    }


}
class Animal implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while(count < 20){
            synchronized (this){
                try {
                    System.out.println(Thread.currentThread().getName()+"吃力第"+count+"块肉");
                    count++;
                    Thread.sleep(100);
                    //this.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
