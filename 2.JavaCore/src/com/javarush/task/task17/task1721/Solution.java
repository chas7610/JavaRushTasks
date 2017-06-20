package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args){

        List<String> fileNameList = new ArrayList<>(2);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileNameList.add(reader.readLine());
            fileNameList.add(reader.readLine());
        }catch (IOException ex){
            System.out.println("Что то не так");}
        finally {
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println("Что то не так");
            }
        }
        try {
            allLines = Files.readAllLines(Paths.get(fileNameList.get(0)));
            forRemoveLines = Files.readAllLines(Paths.get(fileNameList.get(1)));
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        try {
            new Solution().joinData();
        }catch (CorruptedDataException ex){
            System.out.println("Exception: CorruptedDataException");
        }

        System.out.println("");
    }

    public void joinData () throws CorruptedDataException {

//        for (int i = 0; i < fileNameList.size(); i++) {
//            try {
//                reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileNameList.get(i))));
//                if (i==0){
//                    while (reader.ready()){
//                        allLines.add(reader.readLine());
//                    }
//                }
//                else if (i ==1){
//                    while (reader.ready()){
//                        forRemoveLines.add(reader.readLine());
//                    }
//                }
//            }catch (FileNotFoundException ex){
//                System.out.println("file not found");
//            }catch (IOException ex){
//                System.out.println(ex.getMessage());
//            }
//            finally {
//                try {
//                    reader.close();
//                }catch (IOException ex){
//                    System.out.println(ex.getMessage());
//                }
//            }
//        }

        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.removeAll(allLines);
            throw new CorruptedDataException();
        }
    }
}
