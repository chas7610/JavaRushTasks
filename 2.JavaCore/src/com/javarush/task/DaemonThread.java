package com.javarush.task;

import java.util.concurrent.TimeUnit;

/**
 * Created by cherevko-vv on 13.06.2017.
 */
public class DaemonThread {
    public static void main(String[] args) {
        DaemonThrd daemonThrd = new DaemonThrd("1");
        Thread daemon = new Thread(daemonThrd);
        daemon.setDaemon(true);
        daemon.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        }catch (InterruptedException ex){
            System.out.println("InterruptedException");
        }
        daemonThrd.isCancel = true;

    }
    public static class DaemonThrd implements Runnable{
        private String id;
        public boolean isCancel = false;
        private int count;

        public DaemonThrd(String id){
            this.id = id;
        }
        @Override
        public String toString() {
            return id + " <-> " + super.toString();
        }

        @Override

        public void run() {
            while (!isCancel){
                System.out.print(++count);
                System.out.println( " " + this);
            }

        }
    }
}
