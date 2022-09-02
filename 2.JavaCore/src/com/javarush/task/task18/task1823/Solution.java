package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
C:\!tmp\task1822.txt
 */

/* 
Нити и байты
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args)
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            String fileName = reader.readLine();
            while (!fileName.equals("exit"))
            {
                new ReadThread(fileName);
                fileName = reader.readLine();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static class ReadThread extends Thread
    {
        private Map<Integer, Integer> map = new HashMap<>();
        private final String fileName;

        public ReadThread(String fileName)
        {
            this.fileName = fileName;
            this.start();
        }

        @Override
        public void run()
        {
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName)))
            {
                Integer value;
                Integer key;
                while (inputStream.available() > 0)
                {
                    key = inputStream.read();
                    value = map.get(key);

                    if (value == null)
                    {
                        value = 0;
                    }
                    map.put(key, ++value);
                }
            } catch (FileNotFoundException e)
            {
                System.out.println("File not found!");
                return;
            } catch (IOException e)
            {
                System.out.println("I/O error!");
                return;
            }

            Optional<Map.Entry<Integer, Integer>> optionalMaxValue = map.entrySet()
                    .stream()
                    .max((Comparator.comparingInt(Map.Entry::getValue)));
            optionalMaxValue.ifPresent(e -> resultMap.put(fileName, e.getKey()));
//            System.out.println(optionalMaxValue); // XXX
        }
    }
}
