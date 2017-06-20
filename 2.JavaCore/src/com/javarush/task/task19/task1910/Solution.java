package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
//    private static String punctuatioLine = ",.<>/? :;'[]#{}&|()-_=+!%~`\"\\";
    private static String punctuatioLine ="!\\\"#$ %&'()*+,-./:;<=>?@[\\\\]^_`{|}~";
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fNameIn = reader.readLine();
        String fNameOut = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fNameIn));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fNameOut));
        String line = "";
        while (fileReader.ready()){
            int b = fileReader.read();
            if (!isPunctuation(String.valueOf((char)b)) && ((byte)b != 10) && ((byte)b != 13) )
                fileWriter.write(b);
        }
        fileReader.close();
        fileWriter.close();
    }

    public static boolean isPunctuation(String s){
        return punctuatioLine.contains(s);

    }

}
