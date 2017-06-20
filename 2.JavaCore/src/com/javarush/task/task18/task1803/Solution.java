package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        List <Integer> byteList = new ArrayList<>();

        while (fileInputStream.available() > 0){
            int byteKey = fileInputStream.read();
//            byteList.add(byteKey);
            if (!map.containsKey(byteKey))
                map.put(byteKey,1);
            else
                map.put(byteKey, map.get(byteKey) + 1);
        }
        reader.close();
        fileInputStream.close();

        int max = 0;
        for (Map.Entry entry : map.entrySet()){
            if ((int)entry.getValue() > max)
                max = (int)entry.getValue();
        }
        for (Map.Entry entry : map.entrySet()){
            if (entry.getValue().equals(max)) System.out.print(entry.getKey() + " ");
        }

    }
}
