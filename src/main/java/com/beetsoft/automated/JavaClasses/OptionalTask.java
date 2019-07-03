package com.beetsoft.automated.JavaClasses;

/*
Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

4. Abiturient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Оценки.

        Создать массив объектов. Вывести:

        a) список абитуриентов, имеющих неудовлетворительные оценки;

        b) список абитуриентов, у которых сумма баллов выше заданной;

        c) выбрать заданное число n абитуриентов, имеющих самую высокую сумму баллов (вывести также полный список абитуриентов, имеющих полупроходную сумму).*/

import java.util.Scanner;

class Abiturient
{
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String number;
    private int[] marks;

    public Abiturient(int id) {
        this.id = id;
    }

    public Abiturient(int id, String lastName, String firstName, String patronymic, String address, String number, int[] marks) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.number = number;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public String toStringFIO()
    {
        return this.lastName + " " + this.firstName + " " + this.patronymic;
    }
}

public class OptionalTask {

    public static Abiturient[] createAbiturientsList()
    {
        return new Abiturient[10];
    }

    public static void showAbiturientsWithUnsatisfactoryMarks(Abiturient[] abiturients)
    {
        int t = 1;
        System.out.println("\nСписок абитуриентов, имеющих неудовлетворительные оценки: ");
        for (int i = 0; i < abiturients.length; i++)
        {
            if (abiturients[i] != null)
            {
                int[] marks = abiturients[i].getMarks();
                if (marks[0] < 36 || marks[1] < 24 || marks[2] < 40) {
                    System.out.println(t + ". " + abiturients[i].toStringFIO());
                    t++;
                }
            }
            else break;
        }
    }

    public static void main(String[] args)
    {
        Abiturient[] abiturients = createAbiturientsList();
        Scanner in = new Scanner(System.in);
        String answer;

        int id = 0;

        do {
            System.out.println("\nDo you want to add new abiturient? y/n");
            System.out.print("Enter your answer: ");
            answer = in.next();

            if (answer.compareTo("y") == 0)
            {
                int[] marks = new int[3];
                abiturients[id] = new Abiturient(id);
                System.out.print("\nВведите фамилию абитуриента: ");
                abiturients[id].setLastName(in.next());
                System.out.print("\nВведите имя абитуриента: ");
                abiturients[id].setFirstName(in.next());
                System.out.print("\nВведите отчество абитуриента: ");
                abiturients[id].setPatronymic(in.next());
                System.out.print("\nВведите адрес абитуриента: ");
                in.nextLine();
                abiturients[id].setAddress(in.nextLine());
                System.out.print("\nВведите номер телефона абитуриента: ");
                abiturients[id].setNumber(in.next());
                System.out.print("\nВведите оценки абитуриента: ");
                marks[0] = in.nextInt();
                marks[1] = in.nextInt();
                marks[2] = in.nextInt();
                abiturients[id].setMarks(marks);
                id++;
            }
        }while (answer.compareTo("n") != 0);

        showAbiturientsWithUnsatisfactoryMarks(abiturients);

        System.out.println("Введите сумму баллов, выше которой должна быть сумма баллов у абитуриентов: ");
        int answerInt = in.nextInt();

        int temp = 1;
        for (int i = 0; i <= abiturients.length; i++)
        {
            if (abiturients[i] != null) {
                int[] marks = abiturients[i].getMarks();
                int summa = marks[0] + marks[1] + marks[2];
                if (summa >= answerInt)
                {
                    System.out.println(temp + ". " + abiturients[i].getLastName() + " " + abiturients[i].getFirstName() + " " + abiturients[i].getPatronymic());
                    temp++;
                }
            }
            else break;
        }

        System.out.println("Введите сколько абитуриентов с самой высокой суммой баллов отобразить: ");
        answerInt = in.nextInt();

        int[][] pointsAmount = new int[2][abiturients.length];
        for (int i = 0; i < abiturients.length; i++)
        {
            if (abiturients[i] != null)
            {
                int[] marks = abiturients[i].getMarks();
                pointsAmount[0][i] = abiturients[i].getId();
                pointsAmount[1][i] = marks[0] + marks[1] + marks[2];
            }
        }

        int max = pointsAmount[1][0];
        int maxUsed;
        for (int i = 1; i < abiturients.length; i++)
        {
            if (pointsAmount[1][i] > max) max = pointsAmount[1][i];
        }

        for (int i = 0; i < answerInt; i++)
        {
            for (int j = 0; j < abiturients.length; j++)
            {
                if (pointsAmount[1][j] == max) System.out.println((i + 1) + ". " + abiturients[j].getLastName() + " " + abiturients[j].getFirstName() + " " + abiturients[j].getPatronymic()
                                                                    + ". " + pointsAmount[1][j]);
            }
            maxUsed = max;
            for (int j = 0; j < abiturients.length; j++)
            {
                if (pointsAmount[1][j] < maxUsed)
                {
                    max = pointsAmount[1][j];
                    break;
                }
            }
            for (int j = 0; j < abiturients.length; j++)
            {
                if (pointsAmount[1][j] > max && pointsAmount[1][j] < maxUsed) max = pointsAmount[1][j];
            }
        }
    }
}
