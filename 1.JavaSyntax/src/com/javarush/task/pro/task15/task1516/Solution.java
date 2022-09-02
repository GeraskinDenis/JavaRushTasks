package com.javarush.task.pro.task15.task1516;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution
{
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args)
    {
        String str;
        Path path;
        try (Scanner scanner = new Scanner(System.in))
        {
            while (true)
            {
//                System.out.print("Input the path: ");
                str = scanner.nextLine();
                if (str.isEmpty())
//                    break;
                    continue;
                path = Path.of(str);
                if (Files.isDirectory(path))
                    System.out.println(path + THIS_IS_DIR);
                else if (Files.isRegularFile(path))

                    System.out.println(path + THIS_IS_FILE);
                else
                    break;
            }
        } catch (RuntimeException e)
        {
        }

    }
}

