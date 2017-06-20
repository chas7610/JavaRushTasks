package com.javarush.task.task06.task0621;

import javax.smartcardio.CardTerminal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        Cat catGrandFather = new Cat(grandFatherName);
        String grandMotherName = reader.readLine();
        Cat catGrandMother = new Cat(grandMotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null,catGrandFather);


        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catGrandMother, null);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);
        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catFather);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catDaughter);
        System.out.println(catSon);
    }

    public static class Cat {
        private String name;
        private Cat parentMather;
        private Cat parentFather;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parentMather, Cat parentFather) {
            this.name = name;
            this.parentMather = parentMather;
            this.parentFather = parentFather;
        }

        @Override
        public String toString() {
            return "Cat name is " + name + ((parentMather == null)? ", no mother": ", mother is "+ parentMather.name) +  ((parentFather == null)? ", no father": ", father is "+ parentFather.name);
        }
    }

}
