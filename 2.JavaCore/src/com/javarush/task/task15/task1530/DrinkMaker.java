package com.javarush.task.task15.task1530;

/**
 * Created by cherevko-vv on 23.05.2017.
 *
 * — void getRightCup() — выбрать подходящую чашку
 * — void putIngredient() — положить ингредиенты
 * — void pour() — залить жидкостью
 * В классе DrinkMaker создать и реализовать метод void makeDrink(),
 *     который готовит напиток в такой последовательности: выбирает чашку, кладет ингредиенты, заливает жидкостью.
 */
public abstract class DrinkMaker {
    abstract public void getRightCup();
    abstract public void putIngredient();
    abstract public void pour();
    public void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }

}
