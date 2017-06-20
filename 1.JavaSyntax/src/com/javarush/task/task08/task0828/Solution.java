package com.javarush.task.task08.task0828;

import javax.swing.text.html.parser.Entity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.text.DateFormatSymbols;

/* 
Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        Calendar cal = Calendar.getInstance();
        Map<String, Integer> map = cal.getDisplayNames(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        for (Map.Entry<String, Integer> pair : map.entrySet()){
            if (pair.getKey().toLowerCase().equals(month.toLowerCase()))
                System.out.println(month + " is " + (pair.getValue()+1) + " month");
        }
//        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }
}
