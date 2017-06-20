package com.javarush.task.task14.task1408;

/**
 * Created by cherevko-vv on 16.05.2017.
 */
public class BelarusianHen extends Hen{
    private int eggsPerMonth;
    BelarusianHen(){eggsPerMonth = (int)(Math.random()*10);}
    @Override
    int getCountOfEggsPerMonth() {
        return eggsPerMonth;
    }

    @Override
    public String getDescription() {
        return super.getDescription() +String.format(" Моя страна - %s. Я несу %d яиц в месяц.", Country.BELARUS ,getCountOfEggsPerMonth());
    }
}
