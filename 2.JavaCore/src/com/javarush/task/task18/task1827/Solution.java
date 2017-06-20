package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import org.omg.PortableInterceptor.ServerRequestInfo;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int next = nextId(fileName);
        String productName = String.format("%-30s",args[1]);
        String price = String.format("%-8.2f",Double.parseDouble(args[2]));
        String quantity = String.format("%-4d",Integer.parseInt(args[3]));
        String resultLine = String.format("\r\n") + String.valueOf(++next) + productName + price + quantity;
        byte [] line = resultLine.getBytes();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        byte [] buff = new byte[fileInputStream.available()];
        fileInputStream.read(buff);
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(buff);
        fileOutputStream.write(line);
        fileOutputStream.close();
    }
    public static int nextId (String fileName) throws IOException{
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line = "";
        int cout = 0;
        while ((line =fileReader.readLine()) != null){
            cout = Integer.parseInt(line.substring(0,8).trim());
        }
        fileReader.close();
        return cout;
    }
}
