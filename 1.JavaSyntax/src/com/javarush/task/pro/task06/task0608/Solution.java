package com.javarush.task.pro.task06.task0608;

/* 
Кубический калькулятор
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(cube(3L));

    }

    public static long cube(long numLong)
    {
        return numLong * numLong * numLong;
    }
}
