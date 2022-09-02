package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

/*
c:\!tmp\d.txt
c:\!tmp\d1.txt
c:\!tmp\d2.txt
 */
public class Solution
{
    public static void main(String[] args)
    {
        String fileData;
        String fileOutPart1;
        String fileOutPart2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            fileData = reader.readLine();
            fileOutPart1 = reader.readLine();
            fileOutPart2 = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileData));
             BufferedOutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(fileOutPart1));
             BufferedOutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(fileOutPart2)))
        {
            int aByte;
            int sizeOfPart2 = inputStream.available() / 2;
            int currentRemainderOfBytes;
            while ((currentRemainderOfBytes = inputStream.available()) > 0)
            {
                aByte = inputStream.read();
                if (currentRemainderOfBytes > sizeOfPart2)
                {
                    outputStream1.write(aByte);
                } else
                {
                    outputStream2.write(aByte);
                }
            }
            outputStream1.flush();
            outputStream2.flush();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
