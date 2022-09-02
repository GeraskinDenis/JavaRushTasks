package com.javarush.task.task18.task1803;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        Map<Integer, Integer> map = new HashMap<>();

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
        while (inputStream.available() > 0)
        {
            int key = inputStream.read();
            Integer amount = map.get(key);
            if (amount == null)
            {
                map.put(key, 1);
            } else
            {
                map.put(key, ++amount);
            }
        }
        inputStream.close();

        if(map.size() == 0) return;

        int maxAmount = new ArrayList<>(map.values())
                .stream()
                .max(Comparator.naturalOrder())
                .get();

        StringBuilder builder = new StringBuilder();
        map.entrySet()
                .stream()
                .filter(e -> (e.getValue().equals(maxAmount)))
                .forEach(e ->
                {
                    if (builder.length() > 0)
                    {

                        builder.append(" ").append(e.getKey());
                    } else
                    {
                        builder.append(e.getKey());
                    }
                });
        System.out.println(builder);
    }
}
