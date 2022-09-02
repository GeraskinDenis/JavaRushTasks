package com.javarush.task.task15.task1529;

import java.util.Scanner;

/* 
Осваивание статического блока
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    static
    {
        reset();
    }

    public static CanFly result;

    public static void reset()
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals("helicopter"))
        {
            result = new Helicopter();
        } else if (str.equals("plane"))
        {
            result = new Plane(scanner.nextInt());
        }
        scanner.close();
    }
}
