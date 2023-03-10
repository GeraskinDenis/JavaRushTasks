package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        int minByte = Integer.MAX_VALUE;
        while (inputStream.available() > 0)
        {
            int tmp = inputStream.read();
            if (tmp < minByte)
            {
                minByte = tmp;
            }
        }
        inputStream.close();

        System.out.println(minByte);
    }
}
