package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* 
Встречаемость символов
*/

public class Solution
{
    public static void main(String[] args)
    {

//        args = new String[] {"c:\\!tmp\\double.txt"};

        if (args.length == 0) return;

        Map<Integer, Integer> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]))))
        {
            int aChar;
            Integer value;
            while ((aChar = reader.read()) > 0)
            {
                value = map.get(aChar);
                if (value == null)
                {
                    map.put(aChar, 1);
                } else
                {
                    map.put(aChar, ++value);
                }
            }

            map.entrySet().stream()
                    .sorted(Comparator.comparingInt(Map.Entry::getKey))
                    .forEach(e ->
                    {
                        System.out.println((char)(e.getKey().intValue()) + " " + e.getValue());
                    });
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        } catch (IOException e)
        {
            System.out.println("I/O error!");
        }
    }
}
