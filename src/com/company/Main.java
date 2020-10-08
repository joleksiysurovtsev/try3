package com.company;

/*При наполнении массива учитываем что он двухмерный*/


import java.util.Arrays;

public class Main {
    static String[][] lecture = {
            {/*0*/"Java Core", "Head First Java", "Java. Руководство для начинающих"},
            {/*1*/"Core Java API", "Java. Полное руководство", "Java SE 9. Базовый курс", "Java. Методы программирования"},
            {/*2*/"Class design", "Effective Java", "Философия Java"}};


    public static void main(String[] args) {

        System.out.println("Welcome to the learning management system");
        // write your code here
        // getMainMenu();

        getLecture();

        addLecture("Novaya lekciya");
        System.out.println("");
        getLecture();
        getListLit(1);
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
    private static void addLecture(String name) {

        String[][] newArray = new String[lecture.length + 1][];
        String[] add = {name};

        for (int i = 0; i < newArray.length-1; i++) {
            String[] temp = lecture[i];
            newArray[i] = temp;
        }
        newArray[newArray.length-1] = add;

        lecture = newArray;

        System.out.println(Arrays.toString(lecture));


        System.out.println(Arrays.toString(newArray));

    }


}
