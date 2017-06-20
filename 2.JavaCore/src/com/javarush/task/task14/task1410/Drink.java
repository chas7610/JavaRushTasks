package com.javarush.task.task14.task1410;

/**
 * Created by cherevko-vv on 17.05.2017.
 */
public abstract class Drink {
    public void taste(){
        System.out.println("Вкусно");
    }
    abstract public String getHolidayName();
}
