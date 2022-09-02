package com.javarush.task.pro.task15.task1518;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
А что же внутри папки?
*/
// c:\!tmp\a1
// c:\!tmp\a1\1.txt
public class Solution
{

    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        Path directory = Path.of(scanner.nextLine());

//        if (Files.notExists(directory) || !Files.isDirectory(directory))
//            return;

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory))
        {
            for (Path onePath : directoryStream)
            {
                if (Files.isDirectory(onePath))
                    System.out.println(onePath + THIS_IS_DIR);
                else if (Files.isRegularFile(onePath))
                    System.out.println(onePath + THIS_IS_FILE);
            }
        }
    }
}

