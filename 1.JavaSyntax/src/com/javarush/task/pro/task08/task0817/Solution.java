package com.javarush.task.pro.task08.task0817;

public class Solution
{

    public static void main(String[] args)
    {
        int a = 3;
        int b = ++a + (a-- * ++a); //10

        System.out.println(b);
    }
}