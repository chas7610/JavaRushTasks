package com.javarush.task.task18.task1820;

/* 
Округление чисел
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
        while ((line = fileReader.readLine()) != null && !line.equals("")){
            String [] s = line.split(" ");
            for (int i = 0; i < s.length; i++){
                double d = Double.parseDouble(s[i]);
                fileWriter.write(Math.round(d) + " ");
            }
        }
        fileReader.close();
        fileWriter.close();

    }
}
