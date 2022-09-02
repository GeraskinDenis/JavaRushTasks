package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution
{
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {
        String fileName1;
        String fileName2;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1))))
        {
            reader.lines()
                    .forEach(e ->
                    {
                        allLines.add(e);
                    });
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName2))))
        {
            reader.lines()
                    .forEach(e ->
                    {
                        forRemoveLines.add(e);
                    });
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        try
        {
            new Solution().joinData();
        } catch (CorruptedDataException e)
        {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException
    {
        for (String line : forRemoveLines)
        {
            if (!allLines.contains(line))
            {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }

        forRemoveLines.stream()
                .forEach(e -> allLines.remove(e));
    }
}
