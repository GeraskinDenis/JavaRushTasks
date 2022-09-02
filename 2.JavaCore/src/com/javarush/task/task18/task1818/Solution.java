package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution
{
    public static void main(String[] args)
    {
        // Элемент массива с индексом "0" - имя файла для записи
        // Все остальные элементы - имена файлов для чтения
        String[] fileNames = new String[3];

        // Считываем имена файлов с консоли
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            for (int i = 0; i < fileNames.length; i++)
            {
                fileNames[i] = reader.readLine();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }


        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileNames[0], true)))
        {
            // Создаём массив потоков чтения
            BufferedInputStream[] inputStreams = new BufferedInputStream[fileNames.length - 1];
            int indexInputStreams = 0;
            for (int i = 1; i < fileNames.length; i++)
            {
                inputStreams[indexInputStreams++] = new BufferedInputStream(new FileInputStream(fileNames[i]));
            }

            // Читаем и записываем каждый поток по порядку. После прочтения потока - поток закрывается.
            for (BufferedInputStream inputStream : inputStreams)
            {
                while (inputStream.available() > 0)
                {
                    outputStream.write(inputStream.read());
                }
                inputStream.close();
            }
            outputStream.flush();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
