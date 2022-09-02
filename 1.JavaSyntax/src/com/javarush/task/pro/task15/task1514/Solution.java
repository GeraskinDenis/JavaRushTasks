package com.javarush.task.pro.task15.task1514;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Все относительно
*/

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        Path path1;
        Path path2;
        Path emptyPath;

        try
        {
            path1 = Path.of(str1);
            path2 = Path.of(str2);
            emptyPath = Path.of("");
        } catch (RuntimeException e)
        {
            return;
        }

        Path result;
        try
        {
            result = path1.relativize(path2);
            if (!result.equals(emptyPath))
            {
                System.out.println(result);
                return;
            }

        } catch (IllegalArgumentException e)
        {
        }

        try
        {
            result = path2.relativize(path1);
            if (!result.equals(emptyPath))
            {
                System.out.println(result);
                return;
            }

        } catch (IllegalArgumentException e)
        {
        }
    }
}

