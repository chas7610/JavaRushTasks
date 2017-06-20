package com.javarush.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cherevko-vv on 05.06.2017.
 */
public class TestException {
    public static void main(String[] args) {
        try {
            String s = ReadCons.readCon();
            System.out.println(s);;
        }catch (IOException ex){
            System.out.println("IOException");
        }
    }

    public static class ReadCons{
        private static BufferedReader reader;

        public static String readCon() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
        }
    }
}
