package com.javarush.task.task18.task1823;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public  static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = "";
        while (! (inputLine = reader.readLine()).equals("exit")){
            Thread thread = new ReadThread(inputLine);
            thread.start();
        }
        for (Map.Entry entry : resultMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        private FileInputStream fileInputStream;
        private Map<Integer, Integer> map;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
//            this.start();
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                fileInputStream = new FileInputStream(fileName);
                map = new TreeMap<>();
                while (fileInputStream.available()>0){
                    int key = fileInputStream.read();
                    if (map.containsKey(key))
                        map.put(key, map.get(key)+1);
                    else
                        map.put(key,1);
                }
                int max = 0;
                int byteValue = 0;
                for (Map.Entry entry : map.entrySet()){
                    if ((int)entry.getValue() > max){
                        max = (int)entry.getValue();
                        byteValue = (int)entry.getKey();
                    }
                }
                synchronized (resultMap) {
                    resultMap.put(fileName, byteValue);
                }
            }catch (IOException ex){ex.printStackTrace();}
            finally {
                try {
                    fileInputStream.close();
                }catch (IOException ex){ex.printStackTrace();}
            }

        }
    }
}
