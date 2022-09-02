package com.javarush.task.pro.task15.task1510;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Пишем байты в файл
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        byte[] bytes = args[0].getBytes();
//        byte[] bytes = {125, 45, 78, 64}; // XXX
        try (Scanner scanner = new Scanner(System.in))
        {
            String path = scanner.nextLine();
//            String path = "C:\\!tmp\\xxx.txt"; // XXX
            Files.write(Path.of(path), bytes);
        } catch (IOException e)
        {
            System.out.println("Something went wrong : " + e);
        }
    }
}

