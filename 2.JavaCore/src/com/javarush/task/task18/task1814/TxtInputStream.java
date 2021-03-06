package com.javarush.task.task18.task1814;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException, IOException {
        super(fileName);
        if (fileName.indexOf('.') > 0){
            if (!fileName.substring(fileName.lastIndexOf(".")+1).equals("txt")){
                super.close();
                throw new UnsupportedFileNameException();
            }
        }
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

    public static void main(String[] args) {
    }
}

