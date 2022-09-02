package com.javarush.task.pro.task15.task1507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


/* 
Пропускаем не всех
*/

public class Solution
{
    public static void main(String[] args)
    {
        String filePath = null;
        try (Scanner scanner = new Scanner(System.in))
        {
            filePath = scanner.nextLine();
        } catch (NoSuchElementException e)
        {
            e.printStackTrace();
            return;
        }

        if (filePath.isEmpty())
            return;

//        filePath = "C:\\!tmp\\1.txt"; // XXX

        try
        {
            List<String> stringList = Files.readAllLines(Path.of(filePath));
            boolean doPrint = true;
            for (String strLine : stringList)
            {
                if (doPrint)
                {
                    System.out.println(strLine);
                    doPrint = false;
                }else
                {
                    doPrint = true;
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

