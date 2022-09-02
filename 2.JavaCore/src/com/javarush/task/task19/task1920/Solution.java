package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* 
Самый богатый
*/

/*
c:\!tmp\task1920.txt
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
                Double tmpDouble = Double.parseDouble(strings[1]);
                aDouble = (aDouble == null) ? tmpDouble : aDouble + tmpDouble;
                map.put(strings[0], aDouble);
            }
        }

        Double values = map.values()
                .stream()
                .max(Comparator.naturalOrder()).get();

        map.entrySet()
                .stream().filter(e -> (e.getValue().equals(values)))
                .forEach(e ->
                {
                    System.out.println(e.getKey());
                });
    }
}
