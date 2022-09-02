package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {

        int amountOfNum = 0;
        Scanner sc = new Scanner(System.in);
        int intArray[];

//        System.out.print("Enter the amount of numbers: ");
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
            intArray = new int[amountOfNum];
        } else
        {
            System.out.println("The amount of numbers is less than or equal to zero.");
            return;
        }

//        System.out.println("Enter the " + amountOfNum + " numbers:");
        for (int i = 0; i < amountOfNum; i++)
        {
            if(sc.hasNextInt())
            {
                intArray[i] = sc.nextInt();
            } else
            {
                System.out.println("Number input error.");
                return;
            }
        }

        if((amountOfNum % 2) == 0)
        {
            for (int i = intArray.length - 1; i >= 0; i--)
            {
                System.out.println(intArray[i]);
            }
        } else
        {
            for (int i = 0; i < intArray.length; i++)
            {
                System.out.println(intArray[i]);
            }
        }

    }
}
