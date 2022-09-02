package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Писатель в файл с консоли
*/

public class Solution
{
    public static void main(String[] args)
    {

        String strPath;
        List<String> stringList = new ArrayList<String>();

        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in)))
        {
            strPath = input.readLine();

            while (true)
            {
                String strLine = input.readLine();
                stringList.add(strLine);
                if (strLine.equals("exit"))
                    break;
            }

        } catch (Exception e)
        {
            e.printStackTrace();
            return;
        }

//        strPath = "C:\\!tmp\\1.txt";

        try (FileWriter fw = new FileWriter(strPath); BufferedWriter writer = new BufferedWriter(fw))
        {
            for (String oneStr : stringList)
            {
                writer.write(oneStr + "\n");
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
