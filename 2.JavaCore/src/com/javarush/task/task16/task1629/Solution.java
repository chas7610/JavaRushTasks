package com.javarush.task.task16.task1629;
/*
1. В классе Solution создать public static класс нити Read3Strings унаследовавшись от Thread.
2. В методе run реализовать чтение с консоли трех строк.
3. Три подряд введенных строки должны считываться в одной нити и объединяться в одну строку через пробел.
4. В методе main вывести результат для каждой нити.
5. Используй join.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        //add your code here - добавьте код тут
        t1.start();
        t1.join();
        t2.start();
        t2.join();

        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread{
        private String line ="";


        @Override
        public void run() {
            int count = 0;
            while (!isInterrupted()) {
                for (; count<3; )
                //if (count <3)
                {
                    try {
                        //if (reader.ready()) {
                            line += reader.readLine() + " ";
                            count++;
                        //}
                    } catch (IOException ex) {
                    }
                }
                this.interrupt();
                //else
                //    return;
            }
        }

        public void printResult (){
            System.out.println(line);
        }
    }
}
