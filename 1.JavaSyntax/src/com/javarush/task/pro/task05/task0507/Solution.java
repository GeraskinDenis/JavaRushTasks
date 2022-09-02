package com.javarush.task.pro.task05.task0507;

import java.util.Scanner;

/* 
Максимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int amountOfNum;
        int maxInt = Integer.MIN_VALUE;

        if(sc.hasNextInt())
        {
            amountOfNum = sc.nextInt();
        } else
        {
            System.out.println("Number input error.");
            return;
        }

        if (amountOfNum > 0)
        {
            array = new int[amountOfNum];
        } else
        {
            System.out.println("The amount of numbers is less than or equal to zero.");
            return;
        }

        for (int i = 0; i < amountOfNum; i++)
        {
            if(sc.hasNextInt())
            {
                array[i] = sc.nextInt();
            } else
            {
                System.out.println("Number input error.");
                return;
            }
        }

        for (int i = 0; i < array.length; i++)
        {
            if(array[i] > maxInt)
            {
                maxInt = array[i];
            }

        }

        System.out.println(maxInt);

    }
}
