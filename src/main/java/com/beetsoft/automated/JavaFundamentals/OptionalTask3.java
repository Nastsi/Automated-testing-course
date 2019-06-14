package com.beetsoft.automated.JavaFundamentals;

import java.util.Scanner;

public class OptionalTask3 {

    public static void main(String[] args)
    {
        boolean correct = false;
        int month = 0;
        Scanner in = new Scanner(System.in);
        while (correct == false)
        {
            System.out.print("Введите число: ");
            month = in.nextInt();


            if (month < 1 || month > 12)
            {
                System.out.println("Число должно быть от 1 до 12");
            }
            else correct = true;
        }
        in.close();

        switch (month)
        {
            case 1:
                System.out.println("Январь");
                break;
            case 2:
                System.out.println("Февраль");
                break;
            case 3:
                System.out.println("Март");
                break;
            case 4:
                System.out.println("Апрель");
                break;
            case 5:
                System.out.println("Май");
                break;
            case 6:
                System.out.println("Июнь");
                break;
            case 7:
                System.out.println("Июль");
                break;
            case 8:
                System.out.println("Август");
                break;
            case 9:
                System.out.println("Сентябрь");
                break;
            case 10:
                System.out.println("Октябрь");
                break;
            case 11:
                System.out.println("Ноябрь");
                break;
            case 12:
                System.out.println("Декабрь");
                break;
        }
    }
}
