package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

/*
c:\!tmp\task1922.txt
 */
public class Solution
{
    public static List<String> words = new ArrayList<String>();

    static
    {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

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
                    .filter(s ->
                    {
                        int counter = 0;
                        String[] strings = s.split(" ");
                        for (String s1 : strings)
                        {
                            for (String word : words)
                                if (s1.equals(word)) counter++;
                        }
                        return (counter == 2);
                    })
                    .forEach(System.out::println);
        }
    }
}
