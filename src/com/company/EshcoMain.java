package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EshcoMain {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static ListOfLectures ls = new ListOfLectures();

    static void getMainMenu() {
        System.out.println("please make your choice from the offered options\n"
                + "1. display all available lectures (number and title)\n"
                + "2. add a new lecture\n"
                + "3. delete a lecture by its number\n"
                + "4. choose a lecture\n"
                + "0. Exit\n");
    }

    public static void main(String[] args) throws IOException {

        System.out.println(ANSI_BLUE + "Welcome to the learning management system\n" + ANSI_RESET);
        mainMenu();


    }

    static void mainMenu() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        getMainMenu();
        switch (reader.readLine()) {
            case "1":
                ls.getLecture();
                System.out.println("Список вывели что делаем дальше:" + ANSI_GREEN + " \"0\"" + ANSI_RESET + " выйти в верх или " + ANSI_RED + "\"EXIT\"" + ANSI_RESET + " завершить программу");
                String choise = reader.readLine();
                switch (choise) {
                    case "0":
                        mainMenu();
                        break;
                    default:
                        if (choise.equalsIgnoreCase("EXIT")) {
                            System.exit(0);
                        }
                        break;
                }
                break;
            case "2":
                System.out.println("Please enter name for new lecture");
                boolean flag;
                do {
                    flag = false;
                    String name = reader.readLine();
                    ls.addLecture(name);
                    System.out.println("вы ввели новую лекцию если хотите ввести ещё " +
                            "введите " + ANSI_GREEN + "\"+\"" + ANSI_RESET + " \nили " + ANSI_RED + "\"-\"" + ANSI_RESET + " для возврата в главное меню   ");
                    String addOrNot = reader.readLine();
                    if (addOrNot.equalsIgnoreCase("+")) {
                        flag = true;
                        System.out.println("добавляем ещё");
                    } else {
                        if (addOrNot.equalsIgnoreCase("-")) {
                            mainMenu();
                        } else {
                            if (addOrNot.equalsIgnoreCase("EXIT")) {
                                System.exit(0);
                            }
                        }
                    }
                } while (flag);

                break;
            case "3":
                System.out.println("Please enter the number of the lecture you want to delete");

                boolean flagDelete;
                do {
                    flagDelete = false;
                    int number = Integer.parseInt(reader.readLine());
                    ls.removeLecture(number);
                    System.out.println("Лекция удалена хотите ещё одну удалить? " +
                            "если да то введите " + ANSI_RED + "\"+\" " + ANSI_RESET +
                            "если вернуться в меню " + ANSI_GREEN + "\"-\"" + ANSI_RESET + "");
                    String deleteOrNot = reader.readLine();
                    if (deleteOrNot.equalsIgnoreCase("+")) {
                        flagDelete = true;
                        System.out.println("Удаляем ещё введите номер");
                    } else {
                        if (deleteOrNot.equalsIgnoreCase("-")) {
                            mainMenu();
                        } else {
                            if (deleteOrNot.equalsIgnoreCase("EXIT")) {
                                System.exit(0);
                            }
                        }
                    }
                } while (flagDelete);
                break;

            case "4":
                metodViboraLekcii();
                //              System.out.println("введите номер лекции, информацию о которой вы хотите посмотреть");


        }
    }

    /**
     * Prints a String and then terminate the line.  This method behaves as
     * {@link #metodViboraLekcii()}.
     *
     */
    static void metodViboraLekcii() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("введите номер лекции, информацию о которой вы хотите посмотреть если передумали для выхода в меню введите " + ANSI_RED + "0" + ANSI_RESET);

        int numbOfLecture = Integer.parseInt(reader.readLine());
        if (numbOfLecture > ls.getArrLectureLength()){
            System.out.println(ANSI_RED +"Такой лекции не существует"+ ANSI_RESET + "\nдавайте попробуем снова" );
            metodViboraLekcii();
        }else {


            ls.setSelectedLecture(numbOfLecture - 1);
            System.out.println("Выбраная лекция " + ANSI_PURPLE + "\"" + ls.getNameSelectedLecture() + "\"" + ANSI_RESET);
            System.out.println("Какие дальнейшие дейсвия?");
            System.out.println("1. --> просмотреть список литературы");
            ls.getListLit(ls.getSelectedLecture());
            System.out.println("2. --> добавить новую (название / ссылка)");
            System.out.println("3. --> удалить литературу");
            System.out.println("4. --> выйти в меню на уровень выше");
        }

        //вывести список литературы

    }


//    static void podMenu() {
//
//        System.out.println();
//
//
//
//
//
//    }



}
