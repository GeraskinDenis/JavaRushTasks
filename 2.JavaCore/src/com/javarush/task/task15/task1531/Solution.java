package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n)
    {
        if (n < 0) return "0";

        return factorialBigInteger(n).toString();
    }

    private static BigInteger factorialBigInteger(int n)
    {
        if (n == 1 || n == 0)
            return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(factorialBigInteger(n - 1));
    }
}
