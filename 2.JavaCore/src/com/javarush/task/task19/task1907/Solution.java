package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Requirements:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
 */

/* 
Считаем слово
*/

public class Solution
{
    private static int counter = 0;

    public static void main(String[] args)
    {
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            fileName = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        StringBuilder text = new StringBuilder();
        try (FileReader reader = new FileReader(fileName))
        {
            char currentChar;
            while (reader.ready())
            {
                currentChar = (char) reader.read();
                text.append(currentChar);

            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        // \p{Punct} - \p{} обозначает символьные классы, Punct - символьный класс знааков пунктуации один из !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
        // Вся информация в java.util.regex.Pattern
        String replacedString = text.toString().replaceAll("\\p{Punct}", " ").replaceAll("\\s", " ");
        for (String x : replacedString.split(" "))
        {
            if (x.equals("world"))
            {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
