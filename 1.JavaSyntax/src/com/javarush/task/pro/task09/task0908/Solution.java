package com.javarush.task.pro.task09.task0908;

import java.util.Arrays;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution
{

    public static void main(String[] args)
    {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber)
    {

        if (binaryNumber == null || binaryNumber.equals(""))
        {
            return "";
        }

        if (!isBinaryNumber(binaryNumber))
        {
            return "";
        }


        StringBuilder hexNumberBuilder = new StringBuilder();

        if ((binaryNumber.length() % 4) != 0)
        {
            StringBuilder binaryNumberBuilder = new StringBuilder(binaryNumber);
            for (int i = 0; i < (4 - (binaryNumber.length() % 4)); i++)
            {
                binaryNumberBuilder.insert(0, "0");
            }
            binaryNumber = binaryNumberBuilder.toString();
        }

        for (int i = 0; i < binaryNumber.length(); i += 4)
        {
            String oneHEX = fourBitsToHEX(binaryNumber.substring(i, i + 4));
            if (oneHEX.equals(""))
                return "";
            hexNumberBuilder.append(oneHEX);
        }

        return hexNumberBuilder.toString();
    }

    public static String toBinary(String hexNumber)
    {
        if (hexNumber == null || hexNumber.equals(""))
        {
            return "";
        }

        if (!isHexNumber(hexNumber))
        {
            return "";
        }

        StringBuilder binaryNumberBuilder = new StringBuilder();

        for (int i = 0; i < hexNumber.length(); i++)
        {
            String fourBits = oneHEXToFourBits(hexNumber.charAt(i));
            if (fourBits.equals(""))
                return "";
            binaryNumberBuilder.append(fourBits);
        }

        return binaryNumberBuilder.toString();
    }

    private static boolean isBinaryNumber(String binaryNumber)
    {

        for (int i = 0; i < binaryNumber.length(); i++)
        {
            if (binaryNumber.charAt(i) != '0' && binaryNumber.charAt(i) != '1')
            {
                return false;
            }
        }
        return true;
    }

    private static boolean isHexNumber(String hexNumber)
    {
        char[] charsOfHEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (int i = 0; i < hexNumber.length(); i++)
        {
            if (Arrays.binarySearch(charsOfHEX, hexNumber.charAt(i)) == -1)
            {
                return false;
            }
        }
        return true;
    }

    private static String fourBitsToHEX(String fourBits)
    {
        switch (fourBits)
        {
            case "0000":
                return "0";
            case "0001":
                return "1";
            case "0010":
                return "2";
            case "0011":
                return "3";
            case "0100":
                return "4";
            case "0101":
                return "5";
            case "0110":
                return "6";
            case "0111":
                return "7";
            case "1000":
                return "8";
            case "1001":
                return "9";
            case "1010":
                return "a";
            case "1011":
                return "b";
            case "1100":
                return "c";
            case "1101":
                return "d";
            case "1110":
                return "e";
            case "1111":
                return "f";
        }

        return "";
    }

    private static String oneHEXToFourBits(char oneHEX)
    {
        if (oneHEX == '0')
            return "0000";
        else if (oneHEX == '1')
            return "0001";
        else if (oneHEX == '2')
            return "0010";
        else if (oneHEX == '3')
            return "0011";
        else if (oneHEX == '4')
            return "0100";
        else if (oneHEX == '5')
            return "0101";
        else if (oneHEX == '6')
            return "0110";
        else if (oneHEX == '7')
            return "0111";
        else if (oneHEX == '8')
            return "1000";
        else if (oneHEX == '9')
            return "1001";
        else if (oneHEX == 'a')
            return "1010";
        else if (oneHEX == 'b')
            return "1011";
        else if (oneHEX == 'c')
            return "1100";
        else if (oneHEX == 'd')
            return "1101";
        else if (oneHEX == 'e')
            return "1110";
        else if (oneHEX == 'f')
            return "1111";

        return "";
    }

}
