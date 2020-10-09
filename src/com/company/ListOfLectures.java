package com.company;

public class ListOfLectures {
    private static int selectedLecture;

    public static void setSelectedLecture(int selectedLecture) {
        ListOfLectures.selectedLecture = selectedLecture;
    }

    public static int getSelectedLecture() {
        return selectedLecture;
    }

    public static String getNameSelectedLecture() {
        int x = getSelectedLecture();
        String s = lecture[x][0];
        return s;
    }


    private static String[][] lecture = {
            {/*0*/"Java Core", "Head First Java", "Java. Руководство для начинающих"},
            {/*1*/"Core Java API", "Java. Полное руководство", "Java SE 9. Базовый курс", "Java. Методы программирования"},
            {/*2*/"Class design", "Effective Java", "Философия Java"},
            {/*3*/"Тест"}};

    /*МЕТОДЫ ДЛЯ РАБОТЫ C МАСИВОМ*/

    /**
     * Метод выводит в консоль список лекций
     */
    public void getLecture() {
        for (int i = 0; i < lecture.length; i++) {
            int numbOfLecture = i + 1;
            String nameOfLecture = lecture[i][0];
            System.out.println("Lecture №" + numbOfLecture + ". " + nameOfLecture);
        }
        System.out.println(" ");
    }

    /**
     * Добавляет новую лекцию в масив
     */
    public void addLecture(String lectureAddName) {
        String[][] newArray = new String[lecture.length + 1][];
        // из    начиная с  в новый  начиная с  по предпоследний (последний пустой)
        System.arraycopy(lecture, 0, newArray, 0, newArray.length - 1);

        String[] newLecture = {lectureAddName};
        newArray[newArray.length - 1] = newLecture;
        lecture = newArray;
    }

    //Удалить лекцию и масива
    public void removeLecture(int lectureRemove) {
        String[][] newArray1 = new String[lectureRemove - 1][];
        System.arraycopy(lecture, 0, newArray1, 0, newArray1.length);

        String[][] newArray2 = new String[lecture.length - (lectureRemove)][];
        System.arraycopy(lecture, lectureRemove, newArray2, 0, newArray2.length);

        String[][] newArray3 = new String[lecture.length - 1][];
        System.arraycopy(newArray1, 0, newArray3, 0, newArray1.length);
        System.arraycopy(newArray2, 0, newArray3, newArray1.length, newArray2.length);

        lecture = newArray3;
    }


    // Вывод списка литературы
    public void getListLit(int numbLecture) {
        if (lecture[numbLecture].length == 1) {
            System.out.println("\u001B[31m"+"Лекция пустая сначала добавьте в неё литературу" +"\u001B[0m");
        } else {
            for (int i = 1; i < lecture[numbLecture].length; i++) {
                System.out.println(i + ". " + lecture[numbLecture][i]);
            }
        }
    }

    public int getArrLectureLength(){
        return lecture.length;
    }
}
