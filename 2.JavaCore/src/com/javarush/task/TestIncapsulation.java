package com.javarush.task;

import java.lang.reflect.Field;

/**
 * Created by cherevko-vv on 30.05.2017.
 */
public class TestIncapsulation {
    public static void main(String[] args) {
        A a1 = new A("test");
//        try
        {
            Field [] field = a1.getClass().getDeclaredFields();

            for (Field field1 : field){
                System.out.println(field1.getName() + "     "+ field1.getType());
            }
        }
//        catch (NoSuchFieldException ex){
//            System.out.println(ex.getMessage());
        }

    public static class A{
        private String a;
        private int b;
        private double d;
        public A(String a){this.a = a;}
        public String getA(){return a;}
    }
}
