package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* 
Считаем зарплаты
*/

/*
c:\!tmp\task1919.txt
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args.length == 0) return;
        Map<String, Double> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0])))
        {
            while (reader.ready())
            {
                String[] strings = reader.readLine().split(" ");
                Double aDouble = map.get(strings[0]);
                aDouble = (aDouble == null) ? Double.parseDouble(strings[1]) : aDouble + Double.parseDouble(strings[1]);
                map.put(strings[0], aDouble);
            }
        }

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e ->
                {
                    System.out.println(e.getKey() + " " + e.getValue());
                });
    }
}
