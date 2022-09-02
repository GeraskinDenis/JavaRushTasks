package com.javarush.task.task18.task1809;

import java.io.*;

/* 
Реверс файла
*/

public class Solution
{
    public static void main(String[] args)
    {
        String fileData;
        String fileOut;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            fileData = reader.readLine();
            fileOut = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileData));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileOut)))
        {
            int amountBytes = inputStream.available();
            byte[] inBytes = new byte[amountBytes];
            byte[] outBytes = new byte[amountBytes];

            if (amountBytes != inputStream.read(inBytes))
            {
                return;
            }

            int indexOut = 0;
            int indexIn = amountBytes - 1;
            while (indexIn >= 0)
            {
                outBytes[indexOut++] = inBytes[indexIn--];
            }

            outputStream.write(outBytes);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
