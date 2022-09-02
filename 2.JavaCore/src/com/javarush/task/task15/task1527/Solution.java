package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Парсер реквестов
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String paramStr = url.substring(url.indexOf("?") + 1);

        List<String[]> parametersList = Arrays.stream(paramStr.split("&"))
                .map(e -> e.split("="))
                .collect(Collectors.toList());

        List<String> valuesList = new ArrayList<>();

        List<String> namesList = parametersList.stream()
                .map(e ->
                {
                    if (e[0].equals("obj") && e.length == 2)
                    {
                        valuesList.add(e[1]);
                    }
                    return e[0];
                })
                .collect(Collectors.toList());

        System.out.println(String.join(" ", namesList));

        valuesList.stream()
                .forEach(e ->
                {
                    try
                    {
                        alert(Double.parseDouble(e));
                    } catch (NumberFormatException ex)
                    {
                        alert(e);
                    }
                });
    }

    public static void alert(double value)
    {
        System.out.println("double: " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String: " + value);
    }
}
