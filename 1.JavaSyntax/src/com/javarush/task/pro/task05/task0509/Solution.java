package com.javarush.task.pro.task05.task0509;

/* 
Таблица умножения
*/

public class Solution
{

    public static int[][] MULTIPLICATION_TABLE;

    public static void main(String[] args)
    {

        MULTIPLICATION_TABLE = new int[10][10];

        for (int i = 0; i < 10; i++)
        {
            int y = i + 1;
            for (int j = 0; j < 10; j++)
            {
                int x = j + 1;
                MULTIPLICATION_TABLE[i][j] = y * x;
            }
        }

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                System.out.print(MULTIPLICATION_TABLE[i][j] + " ");
            }
            System.out.println();
        }

    }
}
