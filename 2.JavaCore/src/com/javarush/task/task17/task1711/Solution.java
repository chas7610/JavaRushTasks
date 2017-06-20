package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

-c Миронов м 15/04/1990 Симонян ж 15/05/1995
-u 0 Миронов м 15/04/1990 1 Миронова ж 25/07/1997
-d 0 1
-i 0 1

name — имя, String
sex — пол, «м» или «ж», одна буква
bd — дата рождения в следующем формате 15/04/1990
-с — добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u — обновляет соответствующие данные людей с заданными id
-d — производит логическое удаление человека с id, заменяет все его данные на null
-i — выводит на экран информацию о всех людях с заданными id: name sex bd
id соответствует индексу в списке
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]){
            case "-c": synchronized (allPeople){
                ArrayList<Integer> index = new ArrayList<>();
                for (int i = 1; i < args.length-1; i+=3) {
                    Person personNew = null;
                    if (args[i+1].equals("м"))
                        personNew = Person.createMale(args[i],getData(args[i+2]));
                    else if (args[i+1].equals("ж"))
                        personNew = Person.createFemale(args[i],getData(args[i+2]));
                    allPeople.add(personNew);
                    System.out.println(allPeople.indexOf(personNew));
                }
                break;}
            case "-u": synchronized (allPeople){
                for (int i = 1; i < args.length - 1; i +=4){
                    Person personUpdate = allPeople.remove(Integer.parseInt(args[i]));
                    personUpdate.setName(args[i+1]);
                    personUpdate.setSex((args[i+2].equals("м")?Sex.MALE:Sex.FEMALE));
                    personUpdate.setBirthDay(getData(args[i+3]));
                    allPeople.add(Integer.parseInt(args[i]), personUpdate);
                }
                break;}
            case "-d": synchronized (allPeople){
                for (int i = 1; i < args.length; i++){
                    Person personRemove = allPeople.remove(Integer.parseInt(args[i]));
                    personRemove.setName(null);
                    personRemove.setSex(null);
                    personRemove.setBirthDay(null);
                    allPeople.add(Integer.parseInt(args[i]), personRemove);
                }
                break;}
            case "-i": synchronized (allPeople){
                for (int i = 1; i < args.length; i++){
                    Person personInfo = allPeople.get(Integer.parseInt(args[i]));
                    System.out.println(personInfo.getInfo());
                }
                break;}
        }
//        System.out.println("");
    }
    public static Date getData(String strDate){
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            date = dateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
