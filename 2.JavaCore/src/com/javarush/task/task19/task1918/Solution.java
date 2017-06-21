package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class Solution {
    private static boolean test = false;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = null;
        String fNameIn = "c:/tmp/8.html";
        String tegName = "span";
        if (!test){
            reader = new BufferedReader(new InputStreamReader(System.in));
            fNameIn = reader.readLine();
            reader.close();
            tegName = args[0];
        }
        BufferedReader fileReader = new BufferedReader(new FileReader(fNameIn));

        String line = "";
        while (fileReader.ready()){
            line += fileReader.readLine();
        }
        fileReader.close();
        int index = 0;
        List<Integer> startList = new ArrayList<>();
        List<Integer> endList = new ArrayList<>();

        int indexS = 0;
        int indexE = 0;

        while ((indexS != -1) && (indexE != 1) ){
            indexS = line.indexOf(String.format("<%s",tegName),indexS+1);
            indexE = line.indexOf(String.format("</%s",tegName),indexE+1);
            if (indexS != -1)
                startList.add(indexS);
            if (indexE != -1)
                endList.add(indexE);
//            if (indexE > indexS)

        }



//        while (index != -1){
//            index = line.indexOf(String.format("<%s",tegName),index+1);
//            if (index != -1)
//                startList.add(index);
//        }
//        index = 0;
//        while (index != -1){
//            index = line.indexOf(String.format("</%s",tegName),index+1);
//            if (index != -1)
//                endList.add(index);
//        }

        while (startList.size()>0){
            if (startList.size() > 1){
            if (endList.get(0) > startList.get(1)){
                System.out.println(line.substring(startList.get(0),endList.get(1)+ tegName.length()+ 3));
                System.out.println(line.substring(startList.get(1), endList.get(0)+ tegName.length()+ 3));
                startList.remove(1);
                endList.remove(1);
                startList.remove(0);
                endList.remove(0);
            }else{
                System.out.println(line.substring(startList.get(0),endList.get(0)+ tegName.length()+ 3));
                startList.remove(0);
                endList.remove(0);
            }}
            else{
                System.out.println(line.substring(startList.get(0),endList.get(0)+ tegName.length()+ 3));
                startList.remove(0);
                endList.remove(0);
            }

        }

    }
}
