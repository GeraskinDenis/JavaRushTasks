package com.javarush.task.pro.task13.task1308;

import java.util.ArrayList;
import java.util.Collections;

/* 
Изучаем методы класса Collections, часть 3
*/

public class Solution
{

    public static Integer min(ArrayList<Integer> list)
    {
        Integer minimum = Collections.min(list);
        return minimum;
    }

    public static Integer max(ArrayList<Integer> list)
    {
        Integer maximum = Collections.max(list);
        return maximum;
    }

    public static int frequency(ArrayList<Integer> list, Integer element)
    {
        return Collections.frequency(list, element);
    }

    public static int binarySearch(ArrayList<Integer> list, Integer key)
    {
        Collections.sort(list);
        return Collections.binarySearch(list, key);
    }
}
