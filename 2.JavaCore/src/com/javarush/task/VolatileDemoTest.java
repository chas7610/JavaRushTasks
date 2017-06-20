package com.javarush.task;

import sun.java2d.loops.GraphicsPrimitive;

/**
 * Created by cherevko-vv on 06.06.2017.
 */
public class VolatileDemoTest {
    public static void main(String[] args) {

        Clock t1 = new Clock("Clock1");
        Clock t2 = new Clock("Clock2");

        try {
            Thread.sleep(4000);
            Clock.cancel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static class Clock implements   Runnable{

        volatile static private boolean isCanceled = false;
        Thread thrd;
        public Clock(String name){
            thrd = new Thread(this,name);
            thrd.start();
        }

        static public void cancel(){
            isCanceled = true;
        }

        @Override
        public void run() {
            while (true){
                try {
                    System.out.println(thrd.getName());
                    Thread.sleep(500);
                    if (this.isCanceled)
                        break;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
