package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = "";
        String fileO = "";
        Map<Integer, byte[]> map = new TreeMap<>();
        while (!(file = reader.readLine()).equals("end")){
            int partFile = Integer.parseInt(file.substring(file.indexOf("part")+4));
            FileInputStream fileInputStream = new FileInputStream(file);
            byte [] buff = new byte[fileInputStream.available()];
            fileInputStream.read(buff);
            map.put(partFile, buff);
            fileInputStream.close();
            fileO = file;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(fileO.substring(0,fileO.indexOf("part")-1));
        for (Map.Entry entry : map.entrySet()){
            fileOutputStream.write((byte[]) entry.getValue());
        }fileOutputStream.close();

    }
}
