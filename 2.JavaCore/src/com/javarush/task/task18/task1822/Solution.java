package com.javarush.task.task18.task1822;

import java.io.*;

/*
C:\!tmp\task1822.txt
 */

/* 
Поиск данных внутри файла
*/

public class Solution
{
    public static void main(String[] args)
    {
//        args = new String[]{"194"}; // XXX

        if (args.length == 0) return;

        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            fileName = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        String id = args[0];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))))
        {
            reader.lines()
                    .filter(e -> (e.substring(0, e.indexOf(" ")).equals(id)))
                    .forEach(System.out::println);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
