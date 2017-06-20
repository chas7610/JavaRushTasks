package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        Map<Integer, Integer> map = new TreeMap<>();
        while (fileInputStream.available() > 0){
            int i = fileInputStream.read();

            if (!map.containsKey(i))
                map.put(i,1);
            else{
                map.put(i, map.get(i)+1);
            }
        }
        for (Map.Entry entry : map.entrySet()){
            System.out.println((char)((int)entry.getKey()) + " " + entry.getValue());
        }
        fileInputStream.close();
    }
}
