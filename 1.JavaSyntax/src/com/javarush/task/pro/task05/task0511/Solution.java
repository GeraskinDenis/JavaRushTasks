package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution
{
    public static int[][] multiArray;

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int numberOfLines = 0;
        int numberOfColumns = 0;

        if (sc.hasNextInt())
        {
            numberOfLines = sc.nextInt();
        } else
        {
            System.out.println("Number of lines input error.");
            return;
        }

        if (numberOfLines <= 0)
        {
            System.out.println("The number of lines is less then or equal to zero.");
            return;
        }

        multiArray = new int[numberOfLines][];

        for (int i = 0; i < multiArray.length; i++)
        {
            if (sc.hasNextInt())
            {
                numberOfColumns = sc.nextInt();
            } else
            {
                System.out.println("Number of columns input error.");
                return;
            }

            if (numberOfColumns > 0)
            {
                multiArray[i] = new int[numberOfColumns];
            } else
            {
                System.out.println("Number of columns less then or equal to zero.");
                return;
            }

        }

    }
}
