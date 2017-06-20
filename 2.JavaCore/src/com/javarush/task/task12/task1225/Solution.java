package com.javarush.task.task12.task1225;

/* 
Посетители
Напиши метод, который определяет, какой объект передали в него.
Программа должна выводить на экран одну из надписей:
«Кот», «Тигр», «Лев», «Бык», «Корова», «Животное».

Замечание:
постарайся определять тип животного как можно более точно.

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        if (o instanceof Cat)
            return ((Cat) o).getWhoAmI();
        if (o instanceof Animal)
            return ((Animal)o).getDescription();

        return "Животное";
    }

    interface WhoAmI{
        public String getWhoAmI();
    }

    public static class Cat extends Animal implements WhoAmI   //<--Классы наследуются!!
    {
        private String description = "Кот";
        public String getDescription(){return description;}

        @Override
        public String getWhoAmI(){
            return description + "!!";
        }

    }

    public static class Tiger extends Cat {
        private String description = "Тигр";
        public String getDescription(){return description;}

        @Override
        public String getWhoAmI() {
            return description + "!!";
        }
    }

    public static class Lion extends Cat {
        private String description = "Лев";
        public String getDescription(){return description;}

        @Override
        public String getWhoAmI() {
            return description + "!!";
        }
    }

    public static class Bull extends Animal {
        private String description = "Бык";
        public String getDescription(){return description;}
    }

    public static class Cow extends Animal {
        private String description = "Корова";
        public String getDescription(){return description;}
    }

    public static class Animal {
        private String description = "Животное";
        public String getDescription(){return description;}
    }
}
