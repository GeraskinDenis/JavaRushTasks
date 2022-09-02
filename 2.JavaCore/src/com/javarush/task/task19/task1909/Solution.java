package com.javarush.task.task19.task1909;

import java.io.*;

/*
c:\!tmp\task1909.txt
 */

/* 
Замена знаков
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
            while (reader.ready())
            {
                while (reader.ready())
                {
                    char c = (char) reader.read();
                    if (c == '.')
                        writer.write('!');
                    else
                        writer.write(c);
                }
                writer.flush();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
