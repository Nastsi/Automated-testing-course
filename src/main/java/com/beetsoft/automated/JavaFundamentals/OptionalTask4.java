package com.beetsoft.automated.JavaFundamentals;

import java.util.Random;
import java.util.Scanner;

public class OptionalTask4 {

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

        //task 3
        System.out.println("Task 3");
        task3(matr, n);
        System.out.println();
    }
}
