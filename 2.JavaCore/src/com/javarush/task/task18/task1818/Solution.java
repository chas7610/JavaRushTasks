package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = reader.readLine();
        String fName2 = reader.readLine();
        String fName3 = reader.readLine();
        reader.close();
        FileOutputStream fileOutputStream = new FileOutputStream(fName1);
        FileInputStream fileInputStream2 = new FileInputStream(fName2);
        FileInputStream fileInputStream3 = new FileInputStream(fName3);
        byte [] buff = new byte[fileInputStream2.available()];
        fileInputStream2.read(buff);
        fileOutputStream.write(buff);
        buff = new byte[fileInputStream3.available()];
        fileInputStream3.read(buff);
        fileOutputStream.write(buff);

        fileOutputStream.close();
        fileInputStream2.close();
        fileInputStream3.close();
    }
}
