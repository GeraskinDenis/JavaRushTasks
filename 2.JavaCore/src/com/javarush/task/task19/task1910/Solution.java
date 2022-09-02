package com.javarush.task.task19.task1910;

import java.io.*;

/* 
Пунктуация
*/

/*
Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

Результат вывести во второй файл.

Закрыть потоки.


Requirements:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где удалены все знаки пунктуации, включая символы новой строки (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

/*
c:\!tmp\task1910.txt
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String sourceFile;
        String destinationFile;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            sourceFile = reader.readLine();
            destinationFile = reader.readLine();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile)))
        {
            reader.lines()
                    .map(e -> (e.replaceAll("\\p{Punct}", "")))
                    .forEach(e ->
                    {
                        try
                        {
                            writer.write(e);
                        } catch (IOException ex)
                        {
                            ex.printStackTrace();
                        }
                    });
            writer.flush();
        }
    }
}
