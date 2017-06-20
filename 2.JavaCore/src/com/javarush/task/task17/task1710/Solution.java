package com.javarush.task.task17.task1710;

import java.text.*;
import java.util.*;

/* 
CRUD
-c name sex bd
-u id name sex bd
-d id
-i id

-c Миронов м 15/04/1990
-u 0 Миронов м 15/04/1990
-d 1
-i 1
Миронов м 15-Apr-1990

*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch ((String)args[0]){
            case "-c": {
                Person personNew = null;
                if (args[2].equals("м"))
                    personNew = Person.createMale(args[1], getDate(args[3]));
                else if(args[2].equals("ж"))
                    personNew = Person.createFemale(args[1], getDate(args[3]));
                allPeople.add(personNew);
                System.out.println(allPeople.indexOf(personNew));
                break;}
            case "-u": {
                try {
                    Person personUpdate = allPeople.remove(Integer.parseInt(args[1]));
                    personUpdate.setName(args[2]);
                    personUpdate.setSex((args[3].equals("м")?Sex.MALE:Sex.FEMALE));
                    personUpdate.setBirthDay(getDate(args[4]));
                    allPeople.add(Integer.parseInt(args[1]),personUpdate);
                }catch (IndexOutOfBoundsException ex){ System.out.println("Нет такого id"); }

                break;}
            case "-d": {
                try{
                    Person personRemove =  allPeople.remove(Integer.parseInt(args[1]));
                    personRemove.setName(null);
                    personRemove.setBirthDay(null);
                    personRemove.setSex(null);
                    allPeople.add(Integer.parseInt(args[1]), personRemove);
                }catch (IndexOutOfBoundsException ex){
                    System.out.println("Нет такого id");
                }

                break;}
            case "-i": {
                Person printPerson = allPeople.get(Integer.parseInt(args[1]));
                StringBuilder stringPerson = new StringBuilder();
                stringPerson.append(printPerson.getName());
                stringPerson.append(printPerson.getSex() == Sex.MALE?" м ":" ж ");

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String formatted = dateFormat.format(printPerson.getBirthDay());

                stringPerson.append( formatted);
                System.out.println(stringPerson);
                break;}
        }
//        System.out.println("");
    }
    public static Date getDate(String strDate){
        Date date = null;
//        String [] splitDate = strDate.split("/");
//        GregorianCalendar gregorianCalendar = new GregorianCalendar();
//        gregorianCalendar.set(Integer.parseInt(splitDate[2]),(Integer.parseInt(splitDate[1]) - 1), Integer.parseInt(splitDate[0]));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        try {
            date = simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        Date date = gregorianCalendar.getTime();
        return date;
    }
}
