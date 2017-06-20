package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
3.1. Считать с консоли параметр типа String.
3.2. Если параметр равен «helicopter«, то статическому объекту Flyable result присвоить объект класса Helicopter.
3.3. Если параметр равен «plane«, то считать второй параметр типа int(количество пассажиров), статическому объекту Flyable result присвоить объект класса Plane.
*/

public class Solution {
    public static void main(String[] args) {
    }
    
    static {
        reset();
    }

    public static Flyable result;

    public static void reset() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String ts = reader.readLine();
            if (ts.equals("helicopter"))
                result = new Helicopter();
            else if (ts.equals("plane")){
                int passenger = 0;
                try {
                    passenger = Integer.parseInt(reader.readLine());
                }catch (IOException ex){}
                result = new Plane(passenger);
            }
        }catch (IOException ex){}
        finally {
            try {
                reader.close();
            }catch (IOException ex){}
        }
    }
}
