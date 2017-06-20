package com.javarush.task.task14.task1409;

/**
 * Created by cherevko-vv on 17.05.2017.
 */
public class SuspensionBridge implements Bridge {
    final static int carCount = 15;
    @Override
    public int getCarsCount() {
        return carCount;
    }
}
