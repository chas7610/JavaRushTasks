package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
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

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        while (fileReader1.ready())
            list1.add(fileReader1.readLine());
        while (fileReader2.ready())
            list2.add(fileReader2.readLine());

        fileReader1.close();
        fileReader2.close();

        while (list1.size()>0 && list2.size()>0) {
            if (list1.get(0).equals(list2.get(0)))
            {
                lines.add(new LineItem(Type.SAME,list1.get(0)));
                list1.remove(0);
                list2.remove(0);
            }
            else {
                if (list1.get(0).equals(list2.get(1))){
                    lines.add(new LineItem(Type.ADDED,list2.get(0)));
                    list2.remove(0);
                }else {
                    lines.add(new LineItem(Type.REMOVED,list1.get(0)));
                    list1.remove(0);
                }
            }
        }
        while (list1.size() + list2.size() > 0){
            if (list1.size() > 0) {
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
            }
            if (list2.size() > 0) {
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
            }
        }
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
//            return this.type.toString();
        }
    }
}
