package com.javarush.task;

/**
 * Created by cherevko-vv on 24.05.2017.
 */
public class Test_Thread {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread newThread = new Thread(printer);
        Thread newThread1 = new Thread(printer);
        newThread.start();
        newThread1.start();
        try {
            newThread1.join();
        }catch (InterruptedException ex){}

        System.out.println("printer started");
        System.out.println("main thread finished");
        for(int i=0; i < 50; i++){
            System.out.println(String.format("main %d", i));
        }


    }


    public static class Printer implements Runnable{
        @Override
        public void run() {
            System.out.println("I'm printer");
            System.out.println("Printer thread finished");
            for(int i=0; i < 100; i++){
                System.out.println(String.format("printer %d", i));
            }
        }
    }
}

