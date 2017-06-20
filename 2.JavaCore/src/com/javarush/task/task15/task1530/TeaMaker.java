package com.javarush.task.task15.task1530;

/**
 * Created by cherevko-vv on 23.05.2017.
 */
public class TeaMaker extends DrinkMaker {
    @Override
    public void getRightCup() {
        System.out.println("Берем чашку для чая");
    }

    @Override
    public void putIngredient() {
        System.out.println("Насыпаем чай");

    }

    @Override
    public void pour() {
        System.out.println("Заливаем кипятком");
    }
}
