package com.company;

/*При наполнении массива учитываем что он двухмерный*/


import java.util.Arrays;

public class Main {
    static String[][] lecture = {
            {/*0*/"Java Core", "Head First Java", "Java. Руководство для начинающих"},
            {/*1*/"Core Java API", "Java. Полное руководство", "Java SE 9. Базовый курс", "Java. Методы программирования"},
            {/*2*/"Class design", "Effective Java", "Философия Java"}};


    public static void main(String[] args) {

        //System.out.println("Welcome to the learning management system");
        // write your code here
        // getMainMenu();

        getLecture();

        addLecture("Novaya lekciya");
        addLecture("Yenscho odna lekciya");
        System.out.println(" ");
        getLecture();
        System.out.println(" ");
       // getListLit(1);
        System.out.println(" ");
        removeLecture(3);
        getLecture();
    }


    private static void getMainMenu() {
        System.out.println("please make your choice from the offered options\n");
        System.out.println("1. display all available lectures (number and title)");
        System.out.println("2. add a new lecture");
        System.out.println("3. delete a lecture by its number");
        System.out.println("4. choose a lecture");
        System.out.println("5. Exit");
    }



    /*МЕТОДЫ ДЛЯ РАБОТЫ C МАСИВОМ*/

    // Вывод списка лекции
    private static void getLecture() {
        for (int i = 0; i < lecture.length; i++) {
            int numbOfLecture = i + 1;
            String nameOfLecture = lecture[i][0];
            System.out.println("Lecture №" + numbOfLecture + ". " + nameOfLecture);
        }
    }

    // Вывод списка литературы
    private static void getListLit(int numbLecture) {
        for (int i = 1; i < lecture[numbLecture].length; i++) {
            System.out.println(i + ". " + lecture[numbLecture][i]);
        }
    }

    //Добавить новую лекцию в масив
    private static void addLecture(String lectureAddName) {
        String[][] newArray = new String[lecture.length + 1][];
                        // из    начиная с  в новый  начиная с  по предпоследний (последний пустой)
        System.arraycopy(lecture, 0, newArray, 0, newArray.length - 1);

        String[] newLecture = {lectureAddName};
        newArray[newArray.length - 1] = newLecture;
        lecture = newArray;
    }

    //Удалить лекцию и масива
    private static void removeLecture(int lectureRemove) {
        String[][] newArray = new String[lecture.length - 1][];
        System.arraycopy(lecture, 0, newArray, 0, lectureRemove-1);
        System.arraycopy(lecture, lectureRemove, newArray, lectureRemove, 2);

        lecture =newArray;
       // System.out.println(Arrays.toString(newArray));
    }



}
