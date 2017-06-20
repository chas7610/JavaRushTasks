package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte[]buff = new byte[fileInputStream.available()];
        fileInputStream.read(buff);
        int count = 0;
        for (int i = 0; i < buff.length; i++) {
            if (Character.isAlphabetic(buff[i])) count++;
        }
        System.out.println(count);
        fileInputStream.close();
    }
}
