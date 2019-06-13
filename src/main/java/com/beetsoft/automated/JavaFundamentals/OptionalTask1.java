package com.beetsoft.automated.JavaFundamentals;

import java.util.Random;
import java.util.Scanner;

public class OptionalTask1 {

    public static void task1()
    {
        System.out.print("Hello!");
    }
    
    public static void task2(String[] args)
    {
        for (String element: args)
        {
            System.out.println(element);
        }
    }

    public static void task3(int quantity)
    {
        final Random random = new Random();
        for (int i = 0; i < quantity; i++)
        {
            System.out.print(random.nextInt() + " ");
        }
    }

    public static void main(String[] args)
    {
        //Task 1
        System.out.println("Task 1");
        if (args.length != 0) task1();
        System.out.println();

        //Task 2
        System.out.println("Task 2");
        task2(args);
        System.out.println();

        //Task 3
        System.out.println("Task 3");
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("Введите количество чисел, которое необходимо отобразить");
        int quantity = in.nextInt();
        task3(quantity);
        in.close();
    }
}
