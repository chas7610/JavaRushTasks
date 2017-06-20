package com.javarush.task;

/**
 * Created by cherevko-vv on 01.06.2017.
 */
public class Suspend {
    public static class MyThread implements Runnable{
        Thread thrd;
        volatile boolean suspended;
        volatile boolean stopped;

        MyThread(String name){
            thrd = new Thread(this, name);
            suspended = false;
            stopped = false;
            thrd.start();
        }

        @Override
        public void run() {
            System.out.println(thrd.getName() + " - запуск");
            try {
                for (int i = 1; i < 100; i++){
                    System.out.print(i+ " ");
                    if (i%10 == 0){
                        System.out.println();
                        Thread.sleep(250);
                    }
                    synchronized (this){
                        while (suspended){
                            wait();
                        }
                        if (stopped) break;
                    }
                }
            }catch (InterruptedException ex){
                System.out.println(thrd.getName() + " - прерван");
            }
            System.out.println(thrd.getName() + " - выход");
        }
        synchronized void mystop(){
            stopped = true;
            suspended = false;
            notify();
        }
        synchronized void mysuspend(){
            suspended = true;
        }
        synchronized void myresume(){
            suspended = false;
            notify();
        }
    }

    public static void main1(String[] args) {
        MyThread ob1 = new MyThread("MyThread");
        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Приостановка.");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Возобновление.");
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Приостановка.");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Возобновление.");
            Thread.sleep(1000);
            ob1.mystop();
            System.out.println("Остановка.");

        }catch (InterruptedException ex){System.out.println("прерывание основного потока.");}
        try {
            ob1.thrd.join();
        }catch (InterruptedException ex){
            System.out.println("прерывание основного потока.");
        }
        System.out.println("Выход из основного потока.");
    }

    public static class Tic implements Runnable{
        Thread thrd;
        TicToc clock;
        public Tic(String name, TicToc clock){
            thrd = new Thread(this, name);
            this.clock = clock;
            thrd.start();
        }

        @Override
        public void run() {
            while (true){
                    clock.tic();
            }
        }
    }
    public static class Toc implements Runnable{
        Thread thrd;
        TicToc clock;
        public Toc(String name, TicToc clock){
            thrd = new Thread(this, name);
            this.clock = clock;
            thrd.start();
        }

        @Override
        public void run() {
            while (true){
                    clock.toc();
            }

        }
    }

    public static class TicToc{
        String state = "";
        synchronized void tic(){
            try {
                System.out.println(" Tic ");
                Thread.sleep(500);
                state = "tiked";
                notify();
                while (state.equals("tiked")) {
//                    System.out.print(" 1) перед wait ");
                    wait();
//                    System.out.print(" 2) после wait ");
                }
            }catch (InterruptedException ex){
                System.out.println("Прервано.");
            }
        }
        synchronized void toc(){
            try {
                System.out.println(" Toc ");
                Thread.sleep(500);
                state = "toked";
                notify();
                while (state.equals("toked")) {
//                    System.out.print(" 3) перед wait ");
                    wait();
//                    System.out.print(" 4) после wait ");
                }
            }catch (InterruptedException ex){
                System.out.println("Прервано.");
            }
        }
    }

    public static void main(String[] args) {
        TicToc clock = new TicToc();
        new Tic("tic", clock);
        new Toc("toc", clock);
    }
}
