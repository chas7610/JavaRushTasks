package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        Map <String, Double> map  = new TreeMap<>();
        String line = "";
        while ((line = fileReader.readLine()) != null){
            String [] res = line.split(" ");
            if (map.containsKey(res[0]))
                map.put(res[0],map.get(res[0]) + Double.parseDouble(res[1]));
            else
                map.put(res[0],Double.parseDouble(res[1]));
        }
        fileReader.close();
        Double max = 0.0;
        String maxKey = "";
        for (Map.Entry entry : map.entrySet()){
            if ((double)entry.getValue() > max) {
                max = (double) entry.getValue();
//                maxKey = (String )entry.getKey();
            }
        }
        for (Map.Entry entry : map.entrySet()){
            if ((double)entry.getValue() == max)
                System.out.println(entry.getKey());
        }
//        System.out.println(maxKey);
    }
}
