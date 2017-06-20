package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte [] buff = new byte[fileInputStream.available()];
        int countAll = 0;
        int coutSpace = 0;
        fileInputStream.read(buff);
        for (int i = 0; i < buff.length; i++){
            if (Character.isSpaceChar(buff[i]))
                coutSpace++;
            countAll++;
        }
        System.out.println(String.format("%.2f", (double) coutSpace/countAll*100));
        fileInputStream.close();
    }
}
