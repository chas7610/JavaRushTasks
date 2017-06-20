package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fReadName = reader.readLine();
        String fWriteName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fReadName);
        FileWriter fileWriter = new FileWriter(fWriteName);
        int count = 0;
        while(fileReader.ready()) {
            ++count;
            int b = fileReader.read();
            if ( count %2 == 0)
                fileWriter.write(b);
        }
        fileReader.close();
        fileWriter.close();
    }
}
