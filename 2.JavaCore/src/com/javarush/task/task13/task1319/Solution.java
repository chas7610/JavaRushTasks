package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Locale;

/* 
Запись в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку «exit«.
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
        String line = "";
        while (!line.equals("exit")){
            line = reader.readLine();
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}
