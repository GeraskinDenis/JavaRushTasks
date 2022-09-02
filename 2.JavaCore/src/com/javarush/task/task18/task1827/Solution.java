package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.Comparator;
import java.util.Optional;

/* 
Прайсы
*/

// c:\!tmp\5.txt

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        if (args.length == 0) return;

        int lengthOfId = 8;
        int lengthOfName = 30;
        int lengthOfPrice = 8;
        int lengthOfQuantity = 4;

        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            fileName = reader.readLine();
        } catch (IllegalArgumentException e)
        {
            e.printStackTrace();
            return;
        }

        switch (args[0])
        {
            case "-c":
            {
                Optional<Integer> optionalNextId = getNextId(fileName);

                if (!optionalNextId.isPresent()) return;

                int nextId = optionalNextId.get();

                StringBuilder newLine = new StringBuilder(System.lineSeparator())
                        .append(getCorrectLengthString(String.valueOf(nextId), lengthOfId));

                newLine.append(getCorrectLengthString(args[1], lengthOfName))
                        .append(getCorrectLengthString(args[2], lengthOfPrice))
                        .append(getCorrectLengthString(args[3], lengthOfQuantity));

                writeToFile(fileName, newLine.toString());
            }
            default:
            {
                return;
            }
        }
    }

    private static void writeToFile(String fileName, String strLine) throws IOException
    {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName, true)))
        {
            outputStream.write(strLine.getBytes());
            outputStream.flush();
        } catch (IOException e)
        {
            e.printStackTrace();
            throw new IOException(e);
        }
    }

    private static String getCorrectLengthString(String strLine, int length)
    {
        StringBuilder builder = new StringBuilder(strLine);
        if (builder.length() <= length)
        {
            int r = length - builder.length();
            for (int i = 0; i < r; i++)
            {
                builder.append(" ");
            }
        } else
        {
            builder.delete(length, builder.length());
        }
        return builder.toString();
    }

    private static Optional<Integer> getNextId(String fileName)
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))))
        {
            Optional<Integer> optionalMaxId = reader.lines()
                    .map(e -> (e.substring(0, 8).trim()))
                    .map(Integer::parseInt)
                    .max(Comparator.naturalOrder());

            int maxId = 0;
            if (optionalMaxId.isPresent())
            {
                maxId = optionalMaxId.get();
            }
            return Optional.of(++maxId);
        } catch (NumberFormatException e)
        {
            System.out.println("The file contains incorrect indexes!");
            return Optional.empty();
        }catch (IOException e)
        {
            System.out.println("The file not founded!");
            return Optional.empty();
        }
    }
}