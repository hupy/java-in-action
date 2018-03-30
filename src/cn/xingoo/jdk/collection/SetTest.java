package cn.xingoo.jdk.collection;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            new SetTest().linkedHashSetTest();
        }
        long end = System.currentTimeMillis();
        System.out.println("linkedHashSet:"+(end-start));

        start = System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            new SetTest().arrayListTest();
        }
        end = System.currentTimeMillis();
        System.out.println("arrayList:"+(end - start));

        start = System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            new SetTest().linkListTest();
        }
        end = System.currentTimeMillis();
        System.out.println("linkedList:"+(end - start));
    }

    public void linkListTest(){
        List<Student> list = new LinkedList<>();
        Student s1 = new Student("a1",13);
        if(!list.contains(s1)){
            list.add(s1);
        }

        s1 = new Student("a2",13);
        if(!list.contains(s1)){
            list.add(s1);
        }

        s1 = new Student("a3",14);
        if(!list.contains(s1)){
            list.add(s1);
        }

        s1 = new Student("a4",14);
        if(!list.contains(s1)){
            list.add(s1);
        }

        s1 = new Student("a5",15);
        if(!list.contains(s1)){
            list.add(s1);
        }

        s1 = new Student("a6",15);
        if(!list.contains(s1)){
            list.add(s1);
        }

        s1 = new Student("a7",15);
        if(!list.contains(s1)){
            list.add(s1);
        }

//        for(Object s : list){
//            System.out.println(s);
//        }
    }

    public void arrayListTest(){
        List<Student> list = new ArrayList<>();
        Student s1 = new Student("a1",13);
        if(!list.contains(s1)){
            list.add(s1);
        }

        s1 = new Student("a2",13);
        if(!list.contains(s1)){
            list.add(s1);
        }

        s1 = new Student("a3",14);
        if(!list.contains(s1)){
            list.add(s1);
        }

        s1 = new Student("a4",14);
        if(!list.contains(s1)){
            list.add(s1);
        }

        s1 = new Student("a5",15);
        if(!list.contains(s1)){
            list.add(s1);
        }

        s1 = new Student("a6",15);
        if(!list.contains(s1)){
            list.add(s1);
        }

        s1 = new Student("a7",15);
        if(!list.contains(s1)){
            list.add(s1);
        }

//        for(Object s : list){
//            System.out.println(s);
//        }
    }

    public void linkedHashSetTest(){
        Set<Student> set = new LinkedHashSet<>();
        set.add(new Student("a1",13));
        set.add(new Student("a2",13));
        set.add(new Student("a3",14));
        set.add(new Student("a4",14));
        set.add(new Student("a5",15));
        set.add(new Student("a6",15));
        set.add(new Student("a7",15));

//        for(Object s : set.toArray()){
//            System.out.println(s);
//        }
    }

    class Student{
        String name;
        Integer age;
        Student(String name,Integer age){
            this.name = name;
            this.age  = age;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            } else if (!(o instanceof Student)) {
                return false;
            } else {
                Student s = (Student)o;
                return this.age.equals(s.age);
            }
        }

        @Override
        public int hashCode() {
            return age.hashCode();
        }

        @Override
        public String toString() {
            return name+":"+age;
        }
    }
}
