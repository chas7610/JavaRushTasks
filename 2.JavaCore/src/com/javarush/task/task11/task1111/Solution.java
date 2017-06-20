package com.javarush.task.task11.task1111;

/* 
«Из ребра его»
Изменить два класса Adam (Адам) и Eve (Ева).
Унаследовать Еву от Адама.
*/

public class Solution {
    public static void main(String[] args) {
        Adam adam = new Adam();
        Eve eve = new Eve();
    }

    //Адам
    public static class Adam {

    }

    //Ева
    public static class Eve extends Adam{

    }
}
