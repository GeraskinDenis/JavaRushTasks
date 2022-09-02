package com.javarush.task.pro.task15.task1517;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файловые операции
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Path filePath;
        Path fileNewPath;
        try (Scanner scanner = new Scanner(System.in))
        {
            System.out.print("Input the first path: ");
            filePath = Path.of(scanner.nextLine());
            System.out.print("Input the second path: ");
            fileNewPath = Path.of(scanner.nextLine());
        } catch (RuntimeException e)
        {
            System.out.println("The paths were entered incorrectly!");
            return;
        }

        try
        {
            if (Files.isDirectory(filePath) || Files.isDirectory(fileNewPath))
                return;

            if (Files.notExists(filePath))
            {
                Files.createFile(filePath);
            } else
            {
                if (Files.notExists(fileNewPath))
                {
                    Files.move(filePath, fileNewPath);
                } else
                {
                    Files.delete(filePath);
                }
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

