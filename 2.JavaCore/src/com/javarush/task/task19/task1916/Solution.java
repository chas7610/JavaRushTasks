package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = reader.readLine();
        String fName2 = reader.readLine();
        reader.close();

        BufferedReader fileReader1 = new BufferedReader(new FileReader(fName1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(fName2));
        String line1 = "";
        String line2 = "";

        while ((line1 = fileReader1.readLine()) != null | (line2 = fileReader2.readLine()) != null){
            if (line1 == null) line1 = "";
            if (line2 == null) line2 = "";
            if (line1.equals(line2))
                lines.add(new LineItem(Type.SAME,line1));
            else if (line2.length() == 0)
                lines.add(new LineItem(Type.REMOVED,line1));
            else if (line1.length() == 0)
                lines.add(new LineItem(Type.ADDED,line2));
        }
        fileReader1.close();
        fileReader2.close();

        for (LineItem item : lines)
            System.out.println(item);

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return this.type + " " + this.line;
        }
    }
}
