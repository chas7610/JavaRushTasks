package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
        printMatrix((Integer)m, (Integer)n,value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(Integer m, Integer n, String value){
        System.out.println(String.format("%d, %d, %s",m,n,value));
    }
    public static void printMatrix(Double m, Double n, String value){
        System.out.println(String.format("%d, %d, %s",m,n,value));
    }
    public static void printMatrix(Float m, Float n, String value){
        System.out.println(String.format("%d, %d, %s",m,n,value));
    }
    public static void printMatrix(Number m, Number n, String value){
        System.out.println(String.format("%d, %d, %s",m,n,value));
    }
    public static void printMatrix(Integer m, Integer n, Object value){
        System.out.println(String.format("%d, %d, %s",m,n,value));
    }
    public static void printMatrix(Double m, Double n, Object value){
        System.out.println(String.format("%d, %d, %s",m,n,value));
    }
    public static void printMatrix(Float m, Float n, Object value){
        System.out.println(String.format("%d, %d, %s",m,n,value));
    }
    public static void printMatrix(Number m, Number n, Object value){
        System.out.println(String.format("%d, %d, %s",m,n,value));
    }

}
