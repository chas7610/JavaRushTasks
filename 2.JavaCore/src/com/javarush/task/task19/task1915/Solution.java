package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fNameOut = reader.readLine();
        reader.close();
        FileOutputStream fileOutputStream = new FileOutputStream(fNameOut);

        PrintStream out = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);

        testString.printSomething();

        fileOutputStream.write(byteArrayOutputStream.toByteArray());

        System.setOut(out);

        System.out.println(byteArrayOutputStream);
        fileOutputStream.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

