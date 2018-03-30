package cn.xingoo.jdk.thread;

public class School {
    private DingLing dingLing = new DingLing(false);

    class Teacher extends Thread{
        Teacher(String name){
            super(name);
        }
        @Override
        public void run() {
            synchronized (dingLing){
                try {
                    dingLing.wait(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dingLing.flag = true;

                //System.out.println("放学啦");
                //dingLing.notifyAll();

                for (int i = 0; i < 3; i++) {
                    System.out.println("放一个走吧");
                    dingLing.notify();
                    try {
                        dingLing.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    class Student extends Thread{
        Student(String name){
            super(name);
        }
        @Override
        public void run(){
            synchronized (dingLing){
                while(!dingLing.flag){
                    System.out.println(Thread.currentThread().getName()+"开始等待");
                    try {
                        dingLing.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"去吃饭啦");
            }
        }
    }

    public static void main(String[] args) {
        School school = new School();
        Teacher teacher  = school.new Teacher("老师");
        Student zhangsan = school.new Student("张三");
        Student lisi     = school.new Student("李四");
        Student wangwu   = school.new Student("王五");
        teacher.start();
        zhangsan.start();
        lisi.start();
        wangwu.start();
    }
}

class DingLing{
    Boolean flag = false;
    public DingLing(Boolean flag){
        this.flag = flag;
    }
}
