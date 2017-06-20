package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> lineMap = new HashMap<>();
        while (true){
            int id = 0;
            String name = null;
            try {
                id = Integer.parseInt(reader.readLine());
                name = reader.readLine();
            }catch (Exception ex){
                break;
            }
            lineMap.put(name,id);
        }

        for (Map.Entry<String, Integer> pair : lineMap.entrySet()){
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
    }
}
