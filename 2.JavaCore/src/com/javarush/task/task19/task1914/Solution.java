package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream out = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(out);

        String [] op = byteArrayOutputStream.toString().split(" ");
        int a = Integer.parseInt(op[0]);
        int b = Integer.parseInt(op[2]);
        String oper = op[1];
        String res = String.format(" %d %s %d = ",a,oper,b);
        switch (oper){
            case "+":{
                System.out.print(res + (a + b));
                break;}
            case "-":{
                System.out.print(res + (a - b));
                break;}
            case"*":{
                System.out.print(res + (a * b));
                break;
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

