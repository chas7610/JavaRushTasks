package com.javarush.task;

import java.util.ArrayList;

/**
 * Created by cherevko-vv on 19.05.2017.
 */
public class test {
    public static void main(String[] args) {
        Cat tiger = new Tiger(100);
        HasName hasName = (HasName) tiger;
        ArrayList<HasName> hasNamesList = new ArrayList<>();
        hasNamesList.add(hasName);
        hasNamesList.add(new Tiger(200));



        System.out.println(tiger.getName());
        System.out.println((((Tiger)tiger).getWeight()));
        System.out.println(hasName.getName());
        System.out.println(hasName.getWeight());

        for (HasName h : hasNamesList){
            System.out.println(h.toString());
        }
    }
    public static class Cat{
        private String name;
        public Cat(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }
    interface HasName{
        String getName();
        int getWeight();

    }
    public static class Tiger extends Cat implements HasName{
        private int weight;
        public Tiger(int weight){
            super("Iris");
            this.weight = weight;
        }
        public int getWeight(){return weight;}

        @Override
        public String toString() {
            return getName() + " " + getWeight();
        }
    }
}
