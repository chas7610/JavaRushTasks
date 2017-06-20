package com.javarush.task;

import com.sun.xml.internal.ws.api.server.ThreadLocalContainerResolver;

import java.util.ArrayList;
import java.util.Map;


/**
 * Created by cherevko-vv on 26.05.2017.
 */
public class ExtendThread {
    public static void main(String[] args) {
        ArrayList<MyThread> list = new ArrayList<>();
        list.add(new MyThread("salat"));
        list.add(new MyThread("tort"));
        list.add(new MyThread("voda"));
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        for (Map.Entry<Thread,StackTraceElement[]> map1 : map.entrySet()){
//            System.out.println(map1.getKey() + " : " + map1.getValue());
        }
        try {
            list.get(1).join();
        }catch (InterruptedException ex){}

        while (list.get(0).isAlive() || list.get(1).isAlive() || list.get(2).isAlive()){
            try {
                Thread.sleep(300);
                System.out.print(".");
            }catch (InterruptedException ex){}
        }
        System.out.println("The end");
    }
    public static class MyThread extends Thread{
        public MyThread(String s) {
            super(s);
            start();

        }

        @Override
        public void run() {
            int count = (int)(Math.random()*10);
            int i=0;
            try {
                while (!this.isInterrupted()){
                    i++;
                    Thread.sleep(1000);
                    System.out.println(this.getName() + " " + this.getId()  + " tik;");
                    if (count==i)
                        this.interrupt();

                }
            }catch (InterruptedException ex){
                System.out.println(this.isAlive());
            }

        }
    }
}

