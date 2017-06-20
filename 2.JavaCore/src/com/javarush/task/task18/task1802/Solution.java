package com.javarush.task.task18.task1802;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fiStream = new FileInputStream(reader.readLine());
        int min = fiStream.read();
        while (fiStream.available() > 0){
            int m = fiStream.read();
            if (m < min)
                min = m;
        }
        reader.close();
        fiStream.close();
        System.out.println(min);
    }
}
