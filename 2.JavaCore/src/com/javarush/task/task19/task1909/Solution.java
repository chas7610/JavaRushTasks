package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fNameIn = reader.readLine();
        String fNameOut = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fNameIn));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fNameOut));
        String line = "";
        String result = "";
        while ((line = fileReader.readLine()) != null){
            line = line.replace((char)46, (char)33);
            //line = line.replaceAll(String.valueOf((char)46), "!");
            fileWriter.write(line);
        }
        fileReader.close();
        fileWriter.close();
    }
}
