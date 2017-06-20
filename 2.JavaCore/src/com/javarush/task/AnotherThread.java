package com.javarush.task;

/**
 * Created by cherevko-vv on 30.05.2017.
 */
public class AnotherThread {
    public static void main(String[] args) throws InterruptedException{
        MyThread2 t = new MyThread2("MyThread2");
        t.setPriority(Thread.NORM_PRIORITY);
        System.out.println(t.getPriority());
        t.join();
        MyThread t1 =  new MyThread("MyThread");
        t1.thread.join();
        (new MyThread("Another")).thread.join();

//        for (int i = 0; i < 10;){
//            Thread.sleep(450);
//            System.out.println("main thread: " + i);
//            i++;
//        }
        if (!t.isAlive())
            System.out.println("Thread t.isAlive: " + t.isAlive());
        while (t1.thread.isAlive()){
            Thread.sleep(300);
            System.out.println("Thread t1.isAlive: " + t1.thread.isAlive());
        }

        String st1 = new String("привет");
        String st2 = new String("привет");
        System.out.println(st1 == st2);
        System.out.println(st1.equals(st2));
        System.out.println(st1.compareTo(st2));
        st2 = "приветпривет";
        System.out.println(st1.compareTo(st2));
        System.out.println(st2.compareTo(st1));
    }

    public static class MyThread implements Runnable{
        Thread thread;
        String strName;
        public MyThread(String name){
            thread = new Thread(this, name);
            thread.start();
            strName = "MyThreadAnother";
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(400);
                    System.out.println(thread.getName() + " " + i );
                } catch (InterruptedException ex) {
                    ex.getMessage();
                }
            }
            System.out.println(strName.compareTo(thread.getName()));
        }
    }
    public static class MyThread2 extends Thread{
        public MyThread2(String name){
            super(name);
            start();
        }
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(400);
                    System.out.println(getName() + " " + i );
                } catch (InterruptedException ex) {
                    ex.getMessage();
                }
            }
        }
    }
}
