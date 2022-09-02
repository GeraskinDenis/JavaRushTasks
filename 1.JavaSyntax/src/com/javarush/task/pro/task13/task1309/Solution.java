package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("AAA", 1.0);
        grades.put("BBB", 2.0);
        grades.put("CCC", 3.0);
        grades.put("DDD", 4.0);
        grades.put("EEE", 5.0);
    }
}
