package com.javarush.task.pro.task09.task0906;

/*
Двоичный конвертер
*/

public class Solution
{
    public static void main(String[] args)
    {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber)
    {

        if (decimalNumber <= 0) return "";

        String result = "";
        while (decimalNumber != 0)
        {
            result = decimalNumber % 2 + result;
            decimalNumber /= 2;
        }

        return result;
    }

    public static int toDecimal(String binaryNumber)
    {
//        if (binaryNumber == null || binaryNumber.equals("")) return 0;
        if (binaryNumber.equals("") || binaryNumber == null) return 0;

        int decimalNumber = 0;

        int strLength = binaryNumber.length();
        for (int i = 0; i < strLength; i++)
        {
            decimalNumber += Integer.parseInt(Character.toString(binaryNumber.charAt(strLength - 1 - i))) * (int) Math.pow(2, i);
        }

        return decimalNumber;

    }
}
