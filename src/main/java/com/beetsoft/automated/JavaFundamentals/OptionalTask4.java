package com.beetsoft.automated.JavaFundamentals;

import java.util.Random;
import java.util.Scanner;

public class OptionalTask4 {

    public static void task2(int[][] matr, int n)
    {
        int countResult = 0;

        for (int i = 0; i < n; i++)
        {
            int count = 0;

            for (int j = 1; j < n; j++)
            {
                if (count > countResult)
                {
                    countResult = count;
                }

                if (matr[i][j - 1] < matr[i][j])
                {
                    count++;
                }
                else if (matr[i][j - 1] > matr[i][j])
                {
                    count = 0;
                }
            }
        }

        for (int i = 1; i < n; i++)
        {
            int count = 0;

            for (int j = 0; j < n; j++)
            {
                if (count > countResult)
                {
                    countResult = count;
                }

                if (matr[i - 1][j] < matr[i][j])
                {
                    count++;
                }
                else if (matr[i - 1][j] > matr[i][j])
                {
                    count = 0;
                }
            }
        }

        System.out.println("Наибольшее число возрастающих элементов матрицы: " + countResult);
    }

    public static void task3(int[][] matr, int n)
    {
        int sum = 0;
        boolean first = false;
        boolean second = false;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (second == true) break;

                if (matr[i][j] > 0 && first == false)
                {
                    first = true;
                }
                else if (matr[i][j] > 0 && first == true && second == false)
                {
                    second = true;
                }
                else if (first == true && matr[i][j] < 0)
                {
                    sum += matr[i][j];
                }
            }
            first = false;
            second = false;
        }

        System.out.println("Сумма элементов, расположенных между первым и втором положительными элементами каждой строки: " + sum);
    }

    public static void main(String[] args)
    {
        int M = 100;

        System.out.print("Введите размерность матрицы: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] matr = new int[n][n];

        final Random random = new Random();
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matr[i][j] = random.nextInt(M * 2) - M;
            }
        }

        //task 2
        System.out.println("Task 2");
        task2(matr, n);
        System.out.println();

        //task 3
        System.out.println("Task 3");
        task3(matr, n);
        System.out.println();
    }
}
