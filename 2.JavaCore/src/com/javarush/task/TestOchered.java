package com.javarush.task;

/**
 * Created by cherevko-vv on 05.06.2017.
 */
public class TestOchered {
    public static void main(String[] args) {
        FixedQueue fixedQueue = new FixedQueue(10);
        char ch;
        int i;

        try {
            for (i = 0; i < 11; i++) {
                System.out.println("Попытка сохранения: " + (char) ('A' + i));
                fixedQueue.put((char) ('A' + i));
                System.out.println(" - Ok");
            }
            System.out.println();
        }catch(QueueFullException ex){
            System.out.println(ex);
        }
        System.out.println();

        try {
            for (i = 0; i < 11; i++){
                System.out.print("Получение очередного символа: ");
                ch = fixedQueue.get();
                System.out.println(ch);
            }
        }catch (QueueEmptyException ex){
            System.out.println(ex);
        }
    }

    public static class QueueFullException extends Exception {
        int size;
        QueueFullException(int s){
            size = s;
        }
        @Override
        public String toString(){
            return "\nОчередь заполнена. Максимальный размер очереди: " + size;
        }
    }
    public static class QueueEmptyException extends Exception {
        @Override
        public String toString() {
            return "\nОчередь пуста.";
        }
    }

    public static class FixedQueue {
        private char [] q;
        private int putloc, getloc;

        public FixedQueue(int size){
            q = new char[size+1];
            putloc = getloc = 0;
        }
        public void put(char ch) throws QueueFullException {
            if (putloc == q.length-1)
                throw new QueueFullException(q.length-1);
            putloc++;
            q[putloc] = ch;
        }
        public char get() throws QueueEmptyException{
            if (getloc == putloc)
                throw new QueueEmptyException();
            getloc++;
            return q[getloc];
        }
    }
}
