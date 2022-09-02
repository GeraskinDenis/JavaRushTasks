package com.javarush.task.pro.task16.task1601;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Лишь бы не в понедельник:)
*/

public class Solution {

    static Date birthDate = new Date(82, 2, 4);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", new Locale("ru", "RU"));
        String result = simpleDateFormat.format(date);
        return result;
    }
}
