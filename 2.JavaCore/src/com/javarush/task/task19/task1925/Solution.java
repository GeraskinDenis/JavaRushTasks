package com.javarush.task.task19.task1925;

import java.io.*;

/* 
Длинные слова
*/
/*
"c:\!tmp\task1925_f1.txt" "c:\!tmp\task1925_f2.txt"
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 2) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1])))
        {
            StringBuilder builder = new StringBuilder();
            reader.lines()
                    .forEach(line ->
                    {
                        String[] words = line.split(" ");
                        for (String word : words)
                        {
                            if (word.length() > 6)
                            {
                                builder.append((builder.length() > 0) ? "," : "")
                                        .append(word);
                            }
                        }
                    });
            writer.write(builder.toString());
            writer.flush();
        }
    }
}
