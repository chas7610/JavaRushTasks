package com.javarush.task.task14.task1421;

/**
 * Created by cherevko-vv on 17.05.2017.
 */
public class Singleton {
    private static Singleton instance = new Singleton();
//    private static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
//        if (instance==null) instance = new Singleton();
        return instance;
    }
}
