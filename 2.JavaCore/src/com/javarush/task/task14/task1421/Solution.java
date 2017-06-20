package com.javarush.task.task14.task1421;

import java.util.ArrayList;

/*
Singleton
*/
public class Solution {
    public static void main(String[] args) {
    Singleton singleton = Singleton.getInstance();
    Singleton singleton1 = Singleton.getInstance();

        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());
    }
}
