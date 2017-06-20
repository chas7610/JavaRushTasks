package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = "", fName2 = "";
        try {
            fName1 = reader.readLine();
            fName2 = reader.readLine();
        }catch (IOException ex){
            System.out.println("Error");
        }
        finally {
            try {
                reader.close();
            }catch (IOException ex){}
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(fName1);
            byte[] buff = new byte[fileInputStream.available()];
            fileInputStream.read(buff);
            fileInputStream.close();
            FileOutputStream fileOutputStream = new FileOutputStream(fName1);
            fileInputStream = new FileInputStream(fName2);
            byte [] buff1 = new byte[fileInputStream.available()];
            fileInputStream.read(buff1);

            fileOutputStream.write(buff1);
            fileOutputStream.write(buff);

            fileInputStream.close();
            fileOutputStream.close();
        }catch (IOException ex){}

    }
}
