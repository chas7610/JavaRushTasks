package com.javarush.task.task16.task1627;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;

        public static List<String> steps = new ArrayList<String>();

        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) {
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;
        private int coun;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        @Override
        public void run() {
            //Add your code here - добавь код тут
            while (!OnlineGame.isWinnerFound){
                for (int i = 0; i < OnlineGame.steps.size(); i++){
                    try {
                        Thread.sleep(1000/rating);
                        System.out.println(this.getName() + ":" + OnlineGame.steps.get(i));
                    }catch (InterruptedException ex){
                        System.out.println(this.getName() + ":проиграл");
                        return;
                    }
                }
                OnlineGame.isWinnerFound = true;
                System.out.println(this.getName() + ":победитель!");
                return;
            }

//            while (!Thread.currentThread().isInterrupted()){
//                    if (!OnlineGame.isWinnerFound){
//                        if (coun < OnlineGame.steps.size()){
//                            try {
//                                Thread.sleep(1000/rating);
//                                System.out.println(this.getName() + ":" + OnlineGame.steps.get(coun));
//                            }catch (InterruptedException ex){
//                                System.out.println(this.getName() + ":проиграл");
//                                return;
//                            }
//                            coun++;
//                        } else {
//                            OnlineGame.isWinnerFound = true;
//                            System.out.println(this.getName() + ":победитель!");
//                            this.interrupt();
//                            return;
//                        }
//                    }
////                    else {
////                        System.out.println(this.getName() + ":проиграл");
////                        this.interrupt();
////                        return;
////                    }
//            }
        }
    }
}
