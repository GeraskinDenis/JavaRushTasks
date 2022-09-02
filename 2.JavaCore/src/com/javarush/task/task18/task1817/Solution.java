package com.javarush.task.task18.task1817;

import java.io.*;

/* 
Пробелы
*/

public class Solution
{
    public static void main(String[] args)
    {
        if (args.length == 0) return;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]))))
        {
            int aChar;
            int countSpaceChar = 0;
            int countChars = 0;
            while ((aChar = reader.read()) > 0)
            {
                if (Character.isSpaceChar(aChar)) countSpaceChar++;
                countChars++;
            }
            System.out.printf("%.2f", ((double)countSpaceChar / (double) countChars) * 100);
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        } catch (IOException e)
        {
            System.out.println("I/O error!");
        }
    }
}
