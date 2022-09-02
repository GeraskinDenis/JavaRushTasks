package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

/*
c:\!tmp\task1923_f1.txt
c:\!tmp\task1923_f2.txt
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 2) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1])))
        {
            reader.lines()
                    .forEach(line ->
                    {
                        String[] words = line.split(" ");
                        for (String word : words)
                        {
                            if (word.matches("(.*)\\d(.*)"))
                            {
                                try
                                {
                                    writer.write((word + " "));
                                } catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
        }
    }
}
