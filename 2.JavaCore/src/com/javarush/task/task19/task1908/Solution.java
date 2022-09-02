package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Выделяем числа
*/

/*
c:\!tmp\task1908.txt
 */
public class Solution
{
    public static void main(String[] args)
    {
        String sourceFile;
        String destinationFile;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            sourceFile = reader.readLine();
            destinationFile = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile)))
        {
            String line;
            while (reader.ready())
            {
                line = reader.readLine();

                List<String> stringList = Arrays.stream(line.replaceAll("\\p{Punct}", " ")
                                .replaceAll("\\s", " ")
                                .split(" "))
                        .map(String::trim)
                        .filter(Solution::isInteger)
                        .collect(Collectors.toList());

                boolean isFirstNumber = true;

                for (String s : stringList)
                {
                    if (isFirstNumber)
                    {
                        writer.write(s);
                        isFirstNumber = false;
                    }
                    else
                    {
                        writer.write(" " + s);
                    }
                }
                writer.flush();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static boolean isInteger(String s)
    {
        try
        {
            Integer.parseInt(s);
        } catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }
}
