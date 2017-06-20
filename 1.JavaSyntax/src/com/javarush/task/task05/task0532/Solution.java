package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.Arrays;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        do {
            n = Integer.parseInt(reader.readLine());
        }
        while (n<0);
        int [] m  = new int[n];
        for (int i = 0; i < n; i++)
            m[i] = Integer.parseInt(reader.readLine());

        Arrays.sort(m);
        int maximum = m[m.length-1];

        //напишите тут ваш код

        System.out.println(maximum);
    }
}
