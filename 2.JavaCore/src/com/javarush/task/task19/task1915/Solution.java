package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

/*
c:\!tmp\task1915.txt
 */

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {
        String destinationFile;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            destinationFile = reader.readLine();
        }

        PrintStream consolePrintStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        testString.printSomething();
        System.setOut(consolePrintStream);

        try(FileOutputStream fileOutputStream = new FileOutputStream(destinationFile))
        {
            fileOutputStream.write(outputStream.toByteArray());
        }
        System.out.println(outputStream);
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("it's a text for testing");
        }
    }
}

