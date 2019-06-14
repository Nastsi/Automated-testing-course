package com.beetsoft.automated.JavaFundamentals;

import java.util.Scanner;

public class OptionalTask2 {

    public static int findMinLength(int[] numbers)
    {
        int temp = numbers[0];
        int lengthMin = 0;

        do {
            temp /= 10;
            lengthMin++;
        }while (temp != 0);

        for (int i = 1; i < numbers.length; i++)
        {
            int element = numbers[i];
            int length = 0;

            do {
                element /= 10;
                length++;
            }while (element != 0);

            if (length < lengthMin)
            {
                lengthMin = length;
            }
        }

        return lengthMin;
    }

    public static int findMaxLength(int[] numbers)
    {
        int temp = numbers[0];
        int lengthMax = 0;

        do {
            temp /= 10;
            lengthMax++;
        }while (temp != 0);

        for (int i = 1; i < numbers.length; i++)
        {
            int element = numbers[i];
            int length = 0;

            do {
                element /= 10;
                length++;
            }while (element != 0);

            if (length > lengthMax)
            {
                lengthMax = length;
            }
        }

        return lengthMax;
    }

    public static void task1(int[] numbers)
    {
        int mostShort = numbers[0];
        int mostLong = numbers[0];
        int lengthMin = findMinLength(numbers);
        int lengthMax = findMaxLength(numbers);

        for (int i = 1; i < numbers.length; i++)
        {
            int element = numbers[i];
            int length = 0;

            do {
                element /= 10;
                length++;
            }while (element != 0);

            if (length == lengthMin)
            {
                mostShort = numbers[i];
            }

            if (length == lengthMax)
            {
                mostLong = numbers[i];
            }
        }

        System.out.println("Самое короткое число: " + mostShort + ". Его длина: " + lengthMin);
        System.out.println("Самое длинное число: " + mostLong + ". Его длина: " + lengthMax);
    }

    public static void task2(int[] numbers)
    {
        int[] lengths = new int[numbers.length];
        int lengthUsed = findMinLength(numbers);
        int lengthMin = lengthUsed;

        for (int i = 0; i < numbers.length; i++) {
            int element = numbers[i];
            int length = 0;

            do {
                element /= 10;
                length++;
            } while (element != 0);

            lengths[i] = length;
        }

        System.out.print("Числа в порядке возрастания их длины: ");
        int i = 0;
        do
        {
            for (int j = 0; j < lengths.length; j++)
            {
                if (lengths[j] == lengthMin) {
                    System.out.print(numbers[j] + " ");
                    i++;
                }
            }

            lengthUsed = lengthMin;

            for (int j = 0; j < lengths.length; j++)
            {
                if (lengths[j] > lengthUsed)
                {
                    lengthMin = lengths[j];
                    break;
                }
            }
            for (int j = 0; j < lengths.length; j++)
            {
                if (lengths[j] > lengthUsed && lengths[j] < lengthMin) lengthMin = lengths[j];
            }
        }while (i < numbers.length);
    }

    public static void main(String[] args)
    {
        System.out.print("Напишите сколько чисел вы будете вводить: ");
        Scanner in = new Scanner(System.in);
        int quantity = in.nextInt();
        int[] numbers = new int[quantity];
        System.out.print("Введите числа: ");
        for (int i = 0; i < quantity; i++)
        {
            numbers[i] = in.nextInt();
        }
        in.close();

        //Task 1
        System.out.println("Task 1");
        task1(numbers);
        System.out.println();

        //Task 2
        System.out.println("Task 2");
        task2(numbers);
        System.out.println();
    }
}
