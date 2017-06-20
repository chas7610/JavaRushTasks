package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }catch (IOException ex){}
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
//        systemOutPrintln("c:/1/1.txt");
//        systemOutPrintln("c:/1/2.txt");

    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут

    public static class ReadFileThread extends Thread  implements ReadFileInterface{
        private String fullFileName;
        private String content = "";
        BufferedReader reader;

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
//            return "[" + content + "]";
            return content;
        }

        @Override
        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));
                try {
                    while (reader.ready())
                    {
                        content += reader.readLine() + " ";
                    }
                    content = content.trim();
                }catch (IOException ex){}
            }catch (FileNotFoundException ex){}
            finally {
                try {
                    reader.close();
                }catch (IOException ex){}
            }
        }
    }
}
