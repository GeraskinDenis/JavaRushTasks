package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream consolePrintStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        testString.printSomething();

        System.setOut(consolePrintStream);
        String[] lines = outputStream.toString().split("\\n");

        String ad = "JavaRush - курсы Java онлайн";

        for (int i = 0; i < lines.length; i++)
        {
            System.out.println(lines[i]);
            if (((i + 1) % 2) == 0)
            {
                System.out.println(ad);
            }
        }
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
