package com.javarush.task.pro.task08.task0803;

import java.util.Scanner;

/* 
Минимальный элемент массива
*/

public class Solution
{

    public static void main(String[] args)
    {
        int[] intArray = getArrayOfTenElements();
        System.out.println(min(intArray));
    }

    public static int min(int[] ints)
    {

        int minInt = Integer.MAX_VALUE;
        for (int el : ints)
        {
            minInt = Math.min(minInt, el);
        }
        return minInt;

    }

    public static int[] getArrayOfTenElements()
    {

        Scanner sc = new Scanner(System.in);
        int[] arrayInt = new int[10];

        for (int i = 0; i < arrayInt.length; i++)
        {
            if (sc.hasNextInt())
            {
                arrayInt[i] = sc.nextInt();
            } else
            {
                System.out.println("The number input error.");
                return null;
            }
        }

        return arrayInt;

    }
}
