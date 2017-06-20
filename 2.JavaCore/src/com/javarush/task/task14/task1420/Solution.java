package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a=0, b=0;
        try {
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        if (a <= 0 || b <= 0){
            throw new Exception();
        }
        System.out.println(nod(a,b));


    }
    public static int nod(int a, int b) {
        if (b == 0) return a;
        int x = a % b;
        return nod(b, x);
    }
    public class MyException extends Exception{

    }
}

