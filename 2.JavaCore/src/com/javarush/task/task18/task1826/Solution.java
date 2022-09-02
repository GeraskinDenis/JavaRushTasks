package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка
*/

public class Solution
{
    public static void main(String[] args)
    {
        if (args.length == 0) return;

        if (!(args[0].equals("-e") || args[0].equals("-d"))) return;

        String fileSource = args[1];
        String fileReceiver = args[2];

        boolean encrypt = args[0].equals("-e");

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileSource));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileReceiver)))
        {
            if (encrypt)
            {
                while (inputStream.available() > 0)
                {
                    outputStream.write(inputStream.read() + 32);
                }
            } else
            {
                while (inputStream.available() > 0)
                {
                    outputStream.write(inputStream.read() - 32);
                }
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
