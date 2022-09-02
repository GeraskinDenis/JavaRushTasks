package com.javarush.task.task18.task1805;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Сортировка байт
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
        Set<Integer> set = new HashSet<>();
        while (inputStream.available() > 0)
        {
            set.add(inputStream.read());
        }
        inputStream.close();

        StringBuilder builder = new StringBuilder();
        set.stream()
                .sorted()
                .forEach(e ->
                {
                    if (builder.length() != 0)
                    {
                        builder.append(" ").append(e.toString());
                    } else
                    {
                        builder.append(e.toString());
                    }
                });
        System.out.println(builder);
    }
}
