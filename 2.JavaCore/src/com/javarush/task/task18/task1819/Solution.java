package com.javarush.task.task18.task1819;

import java.io.*;

/*
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Requirements:
1. Программа должна два раза считать имена файлов с консоли.
2. Не используй в программе статические переменные.
3. Для первого файла создай поток для чтения и считай его содержимое.
4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
5. Содержимое первого и второго файла нужно объединить в первом файле.
6. Сначала должно идти содержимое второго файла, затем содержимое первого.
7. Созданные для файлов потоки должны быть закрыты.
 */

/* 
Объединение файлов
*/

public class Solution
{
    public static void main(String[] args)
    {
        // Создаём массив для имен файлов
        String[] fileNames = new String[2];

        // Заполняем массив именами файлов из консоли
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

        try
        {
            // Читаем содержимое первого файла в массив
            BufferedInputStream inputStream1 = new BufferedInputStream(new FileInputStream(fileNames[0]));
            byte[] bytes = new byte[inputStream1.available()];
            inputStream1.read(bytes);
            inputStream1.close();

            // Читаем второй файл и пишем в первый
            BufferedInputStream inputStream2 = new BufferedInputStream(new FileInputStream(fileNames[1]));
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileNames[0]));
            while (inputStream2.available() > 0)
            {
                outputStream.write(inputStream2.read());
            }
            inputStream2.close();

            // Записываем данные первого файла из массива
            outputStream.write(bytes);
            outputStream.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
