package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

/*
c:\!tmp\task1926.txt
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String fileName;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            fileName = reader.readLine();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            reader.lines()
                    .forEach(line ->
                    {
                        System.out.println(new StringBuilder(line).reverse());
                    });
        }
    }
}
