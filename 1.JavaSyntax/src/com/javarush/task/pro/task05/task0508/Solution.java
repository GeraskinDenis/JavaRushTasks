package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution
{
    public static String[] strings;

    public static void main(String[] args)
    {

        int numberOfLines = 6;
        strings = new String[numberOfLines];
        Scanner sc = new Scanner(System.in);
        boolean hasIdenticalLine = false;

        for (int i = 0; i < numberOfLines; i++)
        {
            if (sc.hasNextLine())
            {
                strings[i] = sc.nextLine();
            } else
            {
                System.out.println("String input error.");
            }

        }

        for (int i = 0; i < numberOfLines; i++)
        {
            if (strings[i] == null)
            {
                continue;
            }

            hasIdenticalLine = false;
            String tmpStr = strings[i];

            for (int j = strings.length - 1; j >= 0; j--)
            {

                if (strings[j] == null)
                    continue;

                if (tmpStr.equals(strings[j]) && i != j)
                {
                    hasIdenticalLine = true;
                    strings[j] = null;
                }
            }

            if (hasIdenticalLine)
                strings[i] = null;
        }

        for (int i = 0; i < strings.length; i++)
        {
            System.out.print(strings[i] + ", ");
        }
    }
}
