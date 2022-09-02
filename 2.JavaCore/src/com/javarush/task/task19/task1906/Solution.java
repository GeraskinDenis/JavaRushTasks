package com.javarush.task.task19.task1906;

import java.io.*;

/*
c:\!tmp\txtForCopying.txt
 */

/* 
Четные символы
*/

public class Solution
{
    public static void main(String[] args)
    {
        String file1;
        String file2;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            file1 = reader.readLine();
            file2 = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        try (FileReader reader = new FileReader(file1);
             FileWriter writer = new FileWriter(file2))
        {
            int counter = 1;
            while (reader.ready())
            {
                if ((counter++ % 2) == 0)
                {
                    writer.write(reader.read());
                } else
                {
                    reader.skip(1);
                }
            }
            writer.flush();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
