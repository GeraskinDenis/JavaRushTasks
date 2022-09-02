package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;

/* 
Дефрагментация памяти
*/

public class Memory
{

    public static void main(String[] args)
    {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

    public static void executeDefragmentation(String[] array)
    {
        boolean[] freeIndices = new boolean[array.length];
        Arrays.fill(freeIndices, false);

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == null)
            {
                freeIndices[i] = true;
            } else
            {
                int freeIndex = getFreeIndex(freeIndices);
                if (freeIndex < 0) continue;
                array[freeIndex] = array[i];
                array[i] = null;
                freeIndices[i] = true;
            }
        }

    }

    public static int getFreeIndex(boolean[] freeIndices)
    {
        for (int i = 0; i < freeIndices.length; i++)
        {
            if (freeIndices[i])
            {
                freeIndices[i] = false;
                return i;
            }
        }
        return -1;
    }
}
