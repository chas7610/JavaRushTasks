package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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
        while ((line = fileReader.readLine()) != null){
            String [] s = line.split("\\b");
            for (int i = 0; i < s.length; i++){
                try {
                    int n = Integer.parseInt(s[i]);
                    fileWriter.write(n + " ");

                }catch ( NumberFormatException ex){}
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
