package com.beetsoft.automated.JavaFundamentals;

import java.util.Scanner;

public class OptionalTask2 {

    public static int task1(int[] numbers)
    {
        int mostShort = numbers[0];
        int mostLong = numbers[0];
        int lengthShort = 0;
        int lengthLong = 0;
        int temp = numbers[0];

        do {
            temp /= 10;
            lengthLong++;
            lengthShort++;
        }while (temp != 0);

        for (int i = 1; i < numbers.length; i++)
        {
            int element = numbers[i];
            int length = 0;

            do {
                element /= 10;
                length++;
            }while (element != 0);

            if (length < lengthShort)
            {
                lengthShort = length;
                mostShort = numbers[i];
            }

            if (length > lengthLong)
            {
                lengthLong = length;
                mostLong = numbers[i];
            }
        }

        System.out.println("Самое короткое число: " + mostShort + ". Его длина: " + lengthShort);
        System.out.println("Самое длинное число: " + mostLong + ". Его длина: " + lengthLong);

        return lengthShort;
    }

    public static void task2(int[] numbers, int lengthUsed)
    {
        int[] lengths = new int[numbers.length];
        int lengthMin = lengthUsed;
        int lengthNext = lengthUsed;

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
        int lengthMin = task1(numbers);
        System.out.println();

        //Task 2
        System.out.println("Task 2");
        task2(numbers, lengthMin);
        System.out.println();
    }
}
