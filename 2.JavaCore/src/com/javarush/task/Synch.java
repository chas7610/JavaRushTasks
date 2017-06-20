package com.javarush.task;

/**
 * Created by cherevko-vv on 31.05.2017.
 */
public class Synch {
    public static void main(String[] args) {
        int [] num = {1,2,3,4,5};
        MyThread myThread = new MyThread("Поток 1", num);
        MyThread myThread2 = new MyThread("Поток 2", num);
    }
    public static class SumArray{
        private int sum;
        int sumArray(int nums [] ){
            sum = 0;
            for (int i = 0; i<nums.length; i++){
                sum += nums[i];
                System.out.println("Текущее состояние sum для " + Thread.currentThread().getName() + ": " + sum);
                try {
                    Thread.sleep(100);
                }catch (InterruptedException ex){
                    System.out.println("Операция прервана.");
                }
            }
            return sum;
        }
    }
    public static class MyThread implements Runnable{
        Thread thrd;
        int [] a;
        static SumArray sumArray = new SumArray();
        public MyThread(String name, int num[]){
            thrd = new Thread(this, name);
            a = num;
            thrd.start();
        }

        @Override
        public void run() {
            int resSum = 0;
            System.out.println("Запуск потока: " + thrd.getName());
            synchronized (sumArray)
            {
                resSum = sumArray.sumArray(a);
            }
            System.out.println("Сумма в потоке " + thrd.getName() + " = " + resSum);
            System.out.println("Завершение потока " + thrd.getName());
        }
    }
}
