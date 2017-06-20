package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        while (fileInputStream.available() > 0){
            int key = fileInputStream.read();
            if (map.containsKey(key))
                map.put(key, ((int)map.get(key) + 1));
            else map.put(key, 1);
        }
        reader.close();
        fileInputStream.close();
        int min = 10000;
        for (Map.Entry entry : map.entrySet()){
//            min = (int)entry.getValue();
            if ((int)entry.getValue()<min)
                min = (int)entry.getValue();
//            for (Map.Entry entry1 : map.entrySet()){
//                if ((int)entry.getValue()<min)
//                    min = (int)entry.getValue();
//            }
        }
        for (Map.Entry entry : map.entrySet()){
            if ((int)entry.getValue() == min)
                System.out.print(entry.getKey() + " ");
        }
//        System.out.println("");
    }
}
