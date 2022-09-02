package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.Arrays;
/*
-u 123456 123456789012345678901234567890**** 999.99 55
c:\!tmp\5.txt
 */

/* 
Прайсы 2
*/

public class Solution
{
    public static void main(String[] args)
    {
        if (args.length == 0) return;

        if (!(args[0].equals("-u") || args[0].equals("-d"))) return;

        final int idLength = 8;
        final int productNameLength = 30;
        final int priceLength = 8;
        final int quantityLength = 4;

        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            fileName = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        String idStr = getCorrectStringLength(args[1], idLength);

        switch (args[0])
        {
            case "-u":
            {
                StringBuilder newData = new StringBuilder(idLength + productNameLength + priceLength + quantityLength);
                newData.append(idStr)
                        .append(getCorrectStringLength(args[2], productNameLength))
                        .append(getCorrectStringLength(args[3], priceLength))
                        .append(getCorrectStringLength(args[4], quantityLength));

                saveChanges(fileName, idStr, newData.toString());
                break;
            }
            case "-d":
            {
                saveChanges(fileName, idStr, "");
                break;
            }
        }
    }

    private static String getCorrectStringLength(String line, int length)
    {
        int currentLength = line.length();

        if (currentLength == length)
        {
            return line;
        } else if (currentLength < length)
        {
            StringBuilder builder = new StringBuilder(length);
            builder.append(line);
            for (int i = 0; i < length - currentLength; i++)
            {
                builder.append(" ");
            }
            return builder.toString();
        } else
        {
            return line.substring(0, length);
        }
    }

    private static void saveChanges(String fileName, String idStr, String newData)
    {
        String[] strings;
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            int idLength = idStr.length();
            boolean isUpdate = !newData.isEmpty();

            strings = reader.lines()
                    .filter(e -> (isUpdate || !e.substring(0, idLength).equals(idStr)))
                    .map(e ->
                    {
                        if (isUpdate && e.substring(0, idLength).equals(idStr))
                        {
                            return newData;
                        } else
                        {
                            return e;
                        }
                    })
                    .toArray(String[]::new);
            reader.close();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            Arrays.stream(strings)
                    .forEach(e ->
                    {
                        try
                        {
                            writer.write(e + System.lineSeparator());
                        } catch (IOException ex)
                        {
                            ex.printStackTrace();
                        }
                    });

            writer.flush();
            writer.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        } catch (IOException e)
        {
            System.out.println("I/O error!");
        }
    }
}
