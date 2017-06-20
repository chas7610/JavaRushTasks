package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] m = new int[5];
        for (int i = 0; i <5; i++){
            m[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(m);
        for (int i : m){
            System.out.println(i);
        }
    }
}
