package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(10d, "AAA");
        labels.put(10.23d, "BBB");
        labels.put(50.555d, "CCC");
        labels.put(60.1, "DDD");
        labels.put(123d, "EEE");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
