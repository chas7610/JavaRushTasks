package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<String> frutList = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
    for (int i = 0; i < array.length; i++){
        if (isNumber(array[i]))
            numList.add(Integer.parseInt(array[i]));
        else
            frutList.add(array[i]);
    }
        Collections.sort(frutList);
        Collections.sort(numList);
        Collections.reverse(numList);
        for (int i = 0; i < array.length; i++){
            if (isNumber(array[i])) {
                String numString = numList.get(0).toString();
                numList.remove(0);
                array[i] = numString;
            }
            else {
                String fruitString = frutList.get(0);
                frutList.remove(0);
                array[i] = fruitString;

            }
        }
        isGreaterThan(array[0], array[1]);

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
