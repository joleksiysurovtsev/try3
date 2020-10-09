package com.company;

/*При наполнении массива учитываем что он двухмерный*/


public class Main {
    static String[][] lecture = {
            {/*0*/"Java Core",     "Head First Java", "Java. Руководство для начинающих"},
            {/*1*/"Core Java API", "Java. Полное руководство", "Java SE 9. Базовый курс", "Java. Методы программирования"},
            {/*2*/"Class design",  "Effective Java", "Философия Java"}};


    public static void main(String[] args) {

//  getLecture()        вывести все доступные лекции (номер и название)
//  addLecture()        добавить новую лекцию
//  removeLecture()     удалить лекцию по ее номеру
//                              выбрать лекции по ее номеру (после входа в подменю доступны следующие возможности)
//  getListLit()                    просмотреть список литературы
//                                  добавить новую (название  / ссылка)
//                                  удалить литературу
//                              выйти в меню на уровень выше
//                              выйти





        //System.out.println("Welcome to the learning management system");
        // write your code here
        // getMainMenu();

        getLecture();

        addLecture("Novaya lekciya");
        addLecture("Yenscho odna lekciya");
        addLecture("I Yenscho odna lekciya");
        addLecture("II Yenscho odna lekciya");
        System.out.println(" ");
        getLecture();
        System.out.println(" ");
        getListLit(1);

    }






    /*МЕТОДЫ ДЛЯ РАБОТЫ C МАСИВОМ*/

    // Вывод списка лекции
     static void getLecture() {
        for (int i = 0; i < lecture.length; i++) {
            int numbOfLecture = i + 1;
            String nameOfLecture = lecture[i][0];
            System.out.println("Lecture №" + numbOfLecture + ". " + nameOfLecture);
        }
         System.out.println(" ");
    }

    // Вывод списка литературы
     static void getListLit(int numbLecture) {
        for (int i = 1; i < lecture[numbLecture].length; i++) {
            System.out.println(i + ". " + lecture[numbLecture][i]);
        }
    }

    //Добавить новую лекцию в масив
     static void addLecture(String lectureAddName) {
        String[][] newArray = new String[lecture.length + 1][];
        // из    начиная с  в новый  начиная с  по предпоследний (последний пустой)
        System.arraycopy(lecture, 0, newArray, 0, newArray.length - 1);

        String[] newLecture = {lectureAddName};
        newArray[newArray.length - 1] = newLecture;
        lecture = newArray;
    }

    //Удалить лекцию и масива
    private static void removeLecture(int lectureRemove) {
        String[][] newArray1 = new String[lectureRemove - 1][];
        System.arraycopy(lecture, 0, newArray1, 0, newArray1.length);

        String[][] newArray2 = new String[lecture.length - (lectureRemove)][];
        System.arraycopy(lecture, lectureRemove, newArray2, 0, newArray2.length);

        String[][] newArray3 = new String[lecture.length - 1][];
        System.arraycopy(newArray1, 0, newArray3, 0, newArray1.length);
        System.arraycopy(newArray2, 0, newArray3, newArray1.length, newArray2.length);

        lecture = newArray3;
    }



}
