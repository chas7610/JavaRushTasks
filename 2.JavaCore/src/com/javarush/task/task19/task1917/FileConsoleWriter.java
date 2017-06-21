package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/
import java.io.*;

public class FileConsoleWriter {
    public FileConsoleWriter(String fileName) throws IOException{
        fileWriter = new FileWriter(fileName);
    }
    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName,append);
    }
    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file,append);
    }
    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public String getEncoding() {
        return fileWriter.getEncoding();
    }

    public void flush() throws IOException {
        fileWriter.flush();
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.println(String.valueOf(cbuf).substring(off,off+len));
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off,off+len));
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.println(String.valueOf(cbuf));
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public Writer append(CharSequence csq) throws IOException {
        return fileWriter.append(csq);
    }

    public Writer append(CharSequence csq, int start, int end) throws IOException {
        return fileWriter.append(csq, start, end);
    }

    public Writer append(char c) throws IOException {
        return fileWriter.append(c);
    }

    private FileWriter fileWriter;
    public static void main(String[] args) throws IOException{
        File file = new File("c:/temp/5.txt");
        FileConsoleWriter wr =  new FileConsoleWriter(file);
        wr.write( "a".charAt(0));
        wr.write("ku-ku".toCharArray());
        wr.close();

    }

}
