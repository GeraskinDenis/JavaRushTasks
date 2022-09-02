package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        String filePath = null;
        try (Scanner scanner = new Scanner(System.in))
        {
            System.out.print("Enter the path to the file to read:");
            filePath = scanner.nextLine();
        } catch (NoSuchElementException ex)
        {
            ex.printStackTrace();
            return;
        }
//        filePath = "C:\\!tmp\\1.txt";
        try
        {
            List<String> listStr = Files.readAllLines(Path.of(filePath));
            for (String strLine : listStr)
            {
                for (int i = 0; i < strLine.length(); i++)
                {
                    char tmpChar = strLine.charAt(i);
                    if(tmpChar != ' ' && tmpChar != '.' && tmpChar != ',')
                    {
                        System.out.print(tmpChar);
                    }
                }
            }

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}

