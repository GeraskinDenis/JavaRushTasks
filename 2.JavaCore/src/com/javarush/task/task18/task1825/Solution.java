package com.javarush.task.task18.task1825;

/*
c:\!tmp\task1825.txt.part1
c:\!tmp\task1825.txt.part2
c:\!tmp\task1825.txt.part3
 */

/*
Собираем файл
*/

import java.io.*;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class Solution
{
    public static void main(String[] args)
    {
        Set<String> files = new TreeSet<>((o1, o2) ->
        {
            String suffix = "PART".toUpperCase(Locale.ROOT);
            int lengthOfSuffix = suffix.length();
            o1 = o1.toUpperCase(Locale.ROOT);
            o2 = o2.toUpperCase(Locale.ROOT);
            return Integer.parseInt(o1.substring(o1.lastIndexOf(suffix) + lengthOfSuffix))
                    - Integer.parseInt(o2.substring(o2.lastIndexOf(suffix) + lengthOfSuffix));
        });

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            String line = reader.readLine();
            while (!line.equals("end"))
            {
                files.add(line);
                line = reader.readLine();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        String strTmp = files.stream().findFirst().get();
        String fileOutput = strTmp.substring(0, strTmp.lastIndexOf("."));

        try (BufferedOutputStream outputStream = new BufferedOutputStream((new FileOutputStream(fileOutput))))
        {
            files.forEach(e ->
            {
                try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(e)))
                {
                    byte[] bytes = new byte[inputStream.available()];
                    while (inputStream.available() > 0)
                    {
                        int bytesRead = inputStream.read(bytes);
                        outputStream.write(bytes, 0, bytesRead);
                    }
                } catch (FileNotFoundException ex)
                {
                    System.out.println(e + " - file not found.");
                } catch (IOException ioException)
                {
                    System.out.println("I/O error!");
                }
            });
            outputStream.flush();
        } catch (FileNotFoundException e)
        {
            System.out.println(fileOutput + " - file not found.");
        } catch (IOException e)
        {
            System.out.println("I/O error!");
        }
    }
}
