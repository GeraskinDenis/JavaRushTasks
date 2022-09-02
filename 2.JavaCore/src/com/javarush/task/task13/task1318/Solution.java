package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Чтение файла
*/

public class Solution
{
    public static void main(String[] args)
    {
        String strPath;

        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in)))
        {
            strPath = input.readLine();
        } catch (Exception e)
        {
            e.printStackTrace();
            return;
        }

        try (FileInputStream fis = new FileInputStream(strPath);
             InputStreamReader inputStreamReader = new InputStreamReader(fis))
        {
            while (inputStreamReader.ready())
            {
                System.out.print((char) inputStreamReader.read());
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}