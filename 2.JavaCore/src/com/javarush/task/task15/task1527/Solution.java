package com.javarush.task.task15.task1527;

import com.sun.org.apache.regexp.internal.RE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputLine = reader.readLine();
            int pos = inputLine.indexOf('?');
            String line = inputLine.substring(pos+1);
            String[] arg = line.split("&");
            HashMap<String, String > objMap = new HashMap<>();
            for (String s : arg){
                String [] data = s.split("=");
                if (data.length > 1 && data[0].equals("obj"))
                    objMap.put(data[0],data[1]);
                System.out.print(data[0]+ " ");
            }
            System.out.println();
            if (objMap.size()>0){
                String value = objMap.get("obj");
                try {
                    double d = Double.parseDouble(value);
                    alert(d);
                }catch (Exception e){
                    alert(value);
                }
            }

        }catch (IOException ex){}

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
