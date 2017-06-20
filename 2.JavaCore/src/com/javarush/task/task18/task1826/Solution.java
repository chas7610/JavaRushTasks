package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        switch (args[0]){
            case "-e":{
                cryptFile(args[1],args[2]);
                break;
            }
            case "-d":{
                decryptFile(args[1], args[2]);
                break;
            }
        }
    }
    public static void cryptFile(String fileIn, String fileCryptoOut) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(fileIn);
        FileOutputStream fileOutputStream = new FileOutputStream(fileCryptoOut);
        while (fileInputStream.available() > 0){
            fileOutputStream.write(fileInputStream.read()+ Character.charCount('q'));
        }
        fileOutputStream.close();
        fileInputStream.close();
    }
    public static void decryptFile(String fileCryptoIn, String filedecryptOut) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(fileCryptoIn);
        FileOutputStream fileOutputStream = new FileOutputStream(filedecryptOut);
        while (fileInputStream.available() > 0){
            fileOutputStream.write(fileInputStream.read()- Character.charCount('q'));
        }
        fileOutputStream.close();
        fileInputStream.close();
    }
}
