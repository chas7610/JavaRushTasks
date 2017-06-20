package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = "";
        FileInputStream fileInputStream = null;
        while (!(file = reader.readLine()).equals("exit")){
            try {
                fileInputStream = new FileInputStream(file);
                fileInputStream.read();
                fileInputStream.close();
            }catch (FileNotFoundException ex) {
                System.out.println(file);
                break;
            }
//            finally {
//                fileInputStream.close();
//            }
        }
    }
}
