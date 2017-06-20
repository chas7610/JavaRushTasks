package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        List<String> addresses = new ArrayList<String>();
        Map<String,String> map = new HashMap<>();
        while (true) {
            String family = reader.readLine();
            if (family.isEmpty()) break;
            String town = reader.readLine();
            map.put(family,town);
        }

        //read home number
        String findFam = reader.readLine();
//        int houseNumber = Integer.parseInt(reader.readLine());

        for (Map.Entry<String,String> pair : map.entrySet()){
            if (pair.getKey().toLowerCase().equals(findFam.toLowerCase()))
                System.out.println(pair.getValue());
        }
//        if (0 <= houseNumber && houseNumber < addresses.size()) {
//            String familySecondName = addresses.get(houseNumber);
//            System.out.println(familySecondName);
//        }
    }
}
