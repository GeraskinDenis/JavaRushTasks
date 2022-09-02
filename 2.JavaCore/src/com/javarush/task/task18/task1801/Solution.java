package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String fileName;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        int maxByte = Integer.MIN_VALUE;
        while (inputStream.available() > 0)
        {
            int tmp = inputStream.read();
            if (tmp > maxByte) maxByte = tmp;
        }
        inputStream.close();
        System.out.println(maxByte);
    }
}
