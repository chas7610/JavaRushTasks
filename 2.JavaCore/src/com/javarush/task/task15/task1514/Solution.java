package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static
    {
        labels.put(0.5, "0.5");
        labels.put(1.5, "1.5");
        labels.put(2.5, "2.5");
        labels.put(3.5, "3.5");
        labels.put(4.5, "4.5");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
