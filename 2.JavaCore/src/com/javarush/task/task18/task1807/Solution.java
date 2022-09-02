package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution
{
    public static void main(String[] args)
    {
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            fileName = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        int counter = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))))
        {
            int aByte;
            while ((aByte = reader.read()) > 0)
            {
                if ((byte)aByte == ',')
                {
                    counter++;
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println(counter);

    }
}
