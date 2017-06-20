package com.javarush.task.task15.task1529;

/**
 * Created by cherevko-vv on 23.05.2017.
 */
public class Plane implements Flyable {
    int passenger;
    public Plane(int passenger) {
        this.passenger = passenger;
    }

    @Override
    public void fly() {

    }
}
