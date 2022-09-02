package com.javarush.task.pro.task12.task1206;

/* 
Анализ строк
*/

public class Solution
{
    public static void main(String[] args)
    {
        String string = "Думаю, это будет новой фичей." +
                "Только не говорите никому, что она возникла случайно.";

        System.out.println("Количество цифр в строке : " + countDigits(string));
        System.out.println("Количество букв в строке : " + countLetters(string));
        System.out.println("Количество пробелов в строке : " + countSpaces(string));
    }

    public static int countDigits(String string)
    {
        int numberOfDigits = 0;
        for (int i = 0; i < string.length(); i++)
        {
            if (Character.isDigit(string.charAt(i)))
                numberOfDigits++;
        }

        return numberOfDigits;
    }

    public static int countLetters(String string)
    {
        int numberOfLetters = 0;
        for (int i = 0; i < string.length(); i++)
        {
            if (Character.isLetter(string.charAt(i)))
                numberOfLetters++;
        }

        return numberOfLetters;
    }

    public static int countSpaces(String string)
    {
        int numberOfSpaces = 0;
        for (int i = 0; i < string.length(); i++)
        {
            if (Character.isSpaceChar(string.charAt(i)))
                numberOfSpaces++;
        }

        return numberOfSpaces;
    }
}
