package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
1. Ввести с консоли число меньше либо равно 150.
2. Реализовать функцию factorial.
3. Если введенное число меньше 0, то вывести 0.
0! = 1
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        BigDecimal bigDecimal = new BigDecimal(1);
        if (n == 0)
            return Integer.toString(1);
        if (n<0)
            return Integer.toString(0);
        for (n=n; n>0; n--){
            bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(n));
        }
//        if (n == 0)
//            return BigDecimal.valueOf(1).toString();
//        else
//        {
//            bigDecimal = BigDecimal.valueOf(n).multiply(BigDecimal.valueOf(Integer.parseInt(factorial(n-1))));
//        }
        return bigDecimal.toString();
    }
}
