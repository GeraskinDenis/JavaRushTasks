package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream consolePrintStrin = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consolePrintStrin);

        String strLine = outputStream.toString();
        String[] integersStr = strLine.replaceAll("\\s", "").split("\\p{Punct}");
        String operator = strLine.replaceAll("\\s", "").replaceAll("[^+\\-*]", "");

        int[] ints = new int[integersStr.length];
        for (int i = 0; i < integersStr.length; i++)
        {
            ints[i] = Integer.parseInt(integersStr[i]);
        }

        int result = 0;
        String resultStr = String.format("%d %s %d = ", ints[0], operator, ints[1]);

        switch (operator)
        {
            case "+":
            {
                result = ints[0] + ints[1];
                break;
            }
            case "-":
            {
                result = ints[0] - ints[1];
                break;
            }
            case "*":
            {
                result = ints[0] * ints[1];
                break;
            }
        }

        System.out.println(resultStr + result);
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("3 + 6 = ");
        }
    }
}

