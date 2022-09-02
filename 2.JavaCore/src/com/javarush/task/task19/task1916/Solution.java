package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Отслеживаем изменения
*/

/*
c:\!tmp\task1916_file1.txt
c:\!tmp\task1916_file2.txt
 */

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        String file1;
        String file2;
        Queue<String> queueFile1 = new LinkedList<>();
        Queue<String> queueFile2 = new LinkedList<>();

        // Получаем пути к файлам
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            file1 = reader.readLine();
            file2 = reader.readLine();
        }

        // Считываем строки из file1
        try (BufferedReader reader = new BufferedReader(new FileReader(file1)))
        {
            while (reader.ready())
            {
                queueFile1.add(reader.readLine());
            }
        }

        // Считываем строки из file2
        try (BufferedReader reader = new BufferedReader(new FileReader(file2)))
        {
            while (reader.ready())
            {
                queueFile2.add(reader.readLine());
            }
        }

        while (queueFile1.size() != 0 || queueFile2.size() != 0)
        {
            String str1 = queueFile1.poll();
            String str2 = queueFile2.poll();

            if (str1 == null)
            {
                lines.add(new LineItem(Type.ADDED, str2));
                continue;
            }

            if (str2 == null)
            {
                lines.add(new LineItem(Type.REMOVED, str1));
                continue;
            }

            if (str1.equals(str2))
            {
                lines.add(new LineItem(Type.SAME, str1));
                continue;
            }

            String nextStr2 = queueFile2.peek();
            if (str1.equals(nextStr2))
            {
                lines.add(new LineItem(Type.ADDED, str2));
                queueFile2.poll();
                lines.add(new LineItem(Type.SAME, str1));
            } else
            {
                lines.add(new LineItem(Type.REMOVED, str1));
                str1 = queueFile1.poll();
                if (str1 == null)
                {
                    lines.add(new LineItem(Type.ADDED, str2));
                    continue;
                } else
                {
                    lines.add(new LineItem(Type.SAME, str1));
                }
            }
        }
        lines.forEach(e ->
        {
            System.out.println(e.type + " " + e.line);
        });
    }

    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}
