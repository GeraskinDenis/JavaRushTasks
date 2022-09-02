package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Scanner;

/*
Округление чисел
*/

public class Solution
{
    public static void main(String[] args)
    {
//        String fileStr1 = "c:\\!tmp\\double.txt";
//        String fileStr2 = "c:\\!tmp\\int.txt";
        String fileStr1;
        String fileStr2;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            fileStr1 = reader.readLine();
            fileStr2 = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(fileStr1))));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileStr2))))
        {
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNextDouble())
            {
                builder.append((builder.length() > 0) ? " " : "")
                        .append(Math.round(scanner.nextDouble()));
            }
            writer.write(builder.toString());
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
