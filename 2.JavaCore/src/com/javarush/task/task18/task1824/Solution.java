package com.javarush.task.task18.task1824;

import java.io.*;
/*
C:\!tmp\task1822.txt
 */
/* 
Файлы и исключения
*/

public class Solution
{
    public static void main(String[] args) throws Throwable
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            String fileName;
            fileName = reader.readLine();
            while (true)
            {
                try(FileInputStream inputStream = new FileInputStream(fileName);)
                {
                    fileName = reader.readLine();
                } catch(FileNotFoundException ex)
                {
                    System.out.println(fileName);
                    throw new FileNotFoundException().initCause(ex);
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
