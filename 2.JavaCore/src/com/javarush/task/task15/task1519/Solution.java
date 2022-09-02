package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String str = reader.readLine();

            if (str.equals("exit")) break;
            else if (str.contains(".")) // Pattern.matches("\\d+\\.\\d+", str))
            {
                try
                {
                    Double aDouble = Double.parseDouble(str);
                    print(aDouble);
                } catch (NumberFormatException e)
                {
                    print(str);
                }
            } else
            {
                try
                {
                    int integer = Integer.parseInt(str);
                    if (integer > 0 && integer < 128)
                        print((short) integer);
                    else
                        print(integer);
                } catch (NumberFormatException e)
                {
                    print(str);
                }
            }
        }
    }

    public static void print(Double value)
    {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value)
    {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value)
    {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value)
    {
        System.out.println("Это тип Integer, значение " + value);
    }
}
