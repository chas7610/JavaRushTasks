package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fName);
        int count = 0;
        String s = "";
        while (fileReader.ready()){
                s += (char)fileReader.read();
                if (s.contains("world")){
                    count++;
//                    s = s.replaceAll("world","");
                }
        }
        fileReader.close();
//        System.out.println(count);
        System.out.println(s.split("\\bworld\\b").length - 1);

    }
}
