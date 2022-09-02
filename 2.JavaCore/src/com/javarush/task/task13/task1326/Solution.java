package com.javarush.task.task13.task1326;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution
{
    public static void main(String[] args)
    {
        String sourceStr;

        try (Scanner input = new Scanner(System.in))
        {
            sourceStr = input.nextLine();
        } catch (NoSuchElementException e)
        {
            e.printStackTrace();
            return;
        }

        File sourceFile = new File(sourceStr);
//        if (!sourceFile.exists())
//            return;

        List<Integer> integers = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(sourceFile);
             Scanner scanner = new Scanner(inputStream))
        {
            while (scanner.hasNextInt())
            {
                integers.add(scanner.nextInt());

            }
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        integers.stream().filter(e -> ((e % 2) == 0)).sorted().forEach(System.out::println);

    }
}
