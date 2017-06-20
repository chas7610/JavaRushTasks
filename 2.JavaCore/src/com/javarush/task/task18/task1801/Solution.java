package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fn);
        int max = 0;
        while (fileInputStream.available() > 0){
            int r = fileInputStream.read();
            if (r > max)
                max = r;
        }
        fileInputStream.close();
        System.out.println(max);

    }
}
