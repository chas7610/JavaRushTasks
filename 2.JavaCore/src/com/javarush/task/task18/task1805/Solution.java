package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> map = new TreeMap<>();
        while (fileInputStream.available() > 0){
            map.put(fileInputStream.read(),1);
        }
        reader.close();
        fileInputStream.close();

        for (Map.Entry entry : map.entrySet()){
            System.out.print( entry.getKey() + " ");
        }
//        System.out.println("");
    }
}
