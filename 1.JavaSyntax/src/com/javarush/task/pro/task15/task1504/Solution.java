package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution
{
    public static void main(String[] args)
    {
        String inputPath = null;
        String outputPath = null;
        try (Scanner scanner = new Scanner(System.in))
        {
            System.out.print("Enter the path to the source file: ");
            inputPath = scanner.nextLine();
            System.out.print("Enter the path to the output file: ");
            outputPath = scanner.nextLine();
        } catch (NoSuchElementException ex)
        {
            ex.printStackTrace();
            return;
        }

        try (InputStream inputFile = Files.newInputStream(Path.of(inputPath));
             OutputStream outputFile = Files.newOutputStream(Path.of(outputPath)))
        {
            byte[] buffer = new byte[2];
            while (inputFile.available() > 0)
            {
                int real = inputFile.read(buffer);
                if (real == 2)
                {
                    Byte oneByte = null;
                    oneByte = buffer[0];
                    buffer[0] = buffer[1];
                    buffer[1] = oneByte;
                }

                outputFile.write(buffer, 0, real);
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
}

