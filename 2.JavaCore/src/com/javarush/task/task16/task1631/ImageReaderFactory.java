package com.javarush.task.task16.task1631;
import com.javarush.task.task16.task1631.common.*;
/**
 * Created by cherevko-vv on 29.05.2017.
 */


public class ImageReaderFactory {
    private static ImageReader imageReader = null;

    public static ImageReader getImageReader(ImageTypes types){
        if (types.equals(ImageTypes.BMP))
            imageReader = new BmpReader();
        else if (types.equals(ImageTypes.JPG))
            imageReader = new JpgReader();
        else if (types.equals(ImageTypes.PNG))
            imageReader = new PngReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");
        return imageReader;
    }
}
