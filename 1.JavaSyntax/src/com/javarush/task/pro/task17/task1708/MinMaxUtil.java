package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil
{
    public static int min(int a1, int a2)
    {
        int[] a = {a1, a2};
        return min(a);
    }

    public static int min(int a1, int a2, int a3)
    {
        int[] a = {a1, a2, a3};
        return min(a);
    }

    public static int min(int a1, int a2, int a3, int a4)
    {
        int[] a = {a1, a2, a3, a4};
        return min(a);
    }

    public static int min(int a1, int a2, int a3, int a4, int a5)
    {
        int[] a = {a1, a2, a3, a4, a5};
        return min(a);
    }

    private static int min(int[] a)
    {
        int min = Integer.MAX_VALUE;
        for (int tmp : a)
        {
            if (tmp < min)
                min = tmp;
        }
        return min;
    }

    public static int max(int a1, int a2)
    {
        int[] a = {a1, a2};
        return max(a);
    }

    public static int max(int a1, int a2, int a3)
    {
        int[] a = {a1, a2, a3};
        return max(a);
    }

    public static int max(int a1, int a2, int a3, int a4)
    {
        int[] a = {a1, a2, a3, a4};
        return max(a);
    }

    public static int max(int a1, int a2, int a3, int a4, int a5)
    {
        int[] a = {a1, a2, a3, a4, a5};
        return max(a);
    }

    private static int max(int[] a)
    {
        int max = Integer.MIN_VALUE;
        for (int tmp : a)
        {
            if (tmp > max)
                max = tmp;
        }
        return max;
    }
}
