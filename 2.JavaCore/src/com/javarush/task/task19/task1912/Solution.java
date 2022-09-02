package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка 2
*/

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream consolePrint = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        String text = outputStream.toString().replaceAll("te", "??");
        System.setOut(consolePrint);
        System.out.println(text);
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("it's a text for testing");
        }
    }
}
