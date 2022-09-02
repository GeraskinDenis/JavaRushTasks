package com.javarush.task.pro.task15.task1521;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Временное сохранение файла
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String line;
        try (Scanner scanner = new Scanner(System.in))
        {
            line = scanner.nextLine();
        } catch (RuntimeException e)
        {
            return;
        }

        URL url;
        try
        {
            url = new URL(line);

        } catch (MalformedURLException e)
        {
            return;
        }

        try (InputStream inputStream = url.openStream())
        {
            byte[] buffer = inputStream.readAllBytes();
            Path tmpFile = Files.createTempFile(null, null);
            Files.write(tmpFile, buffer);
        }
    }
}