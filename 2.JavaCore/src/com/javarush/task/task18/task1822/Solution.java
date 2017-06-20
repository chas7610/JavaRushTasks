package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
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
        BufferedReader readerFile = new BufferedReader(new FileReader(fName));

        while (readerFile.ready()){
            String l = readerFile.readLine();
            String [] line = l.split(" ");
            if (Integer.parseInt(line[0])== Integer.parseInt(args[0])){
//                System.out.printf("%d %s %.2f %d", Integer.parseInt(line[0]), line[1], Double.parseDouble(line[2]), Integer.parseInt(line[3]));
                System.out.println(l);
                break;
            }
        }
        readerFile.close();
    }
}
