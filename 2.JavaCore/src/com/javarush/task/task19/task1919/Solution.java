package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String line = "";
        Map<String, Double> map = new TreeMap<>();
        ArrayList<String> lastName = new ArrayList<>();
        while ((line = fileReader.readLine()) != null){
            String [] res = line.split(" ");
            if (map.containsKey(res[0]))
                map.put(res[0],map.get(res[0]) + Double.parseDouble(res[1]));
            else{
                map.put(res[0], Double.parseDouble(res[1]));
                lastName.add(res[0]);
            }
        }
        fileReader.close();
        Collections.sort(lastName);
        for (String key : lastName){
            System.out.println(key + " " + map.get(key));
        }
//        System.out.println();
//        for (Map.Entry entry : map.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
    }
}
