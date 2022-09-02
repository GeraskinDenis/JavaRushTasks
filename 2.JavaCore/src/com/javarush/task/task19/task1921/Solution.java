package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

/* 
Хуан Хуанович
*/

/*
c:\!tmp\task1921.txt
 */
public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        if (args.length == 0) return;

        List<String[]> list;

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0])))
        {
            list = reader.lines()
                    .map(s -> s.split(" "))
                    .collect(Collectors.toList());
        }

        for (String[] strings : list)
        {
            int year = Integer.parseInt(strings[strings.length - 1]);
            int month = Integer.parseInt(strings[strings.length - 2]) - 1;
            int day = Integer.parseInt(strings[strings.length - 3]);

            Calendar date = new GregorianCalendar(year, month, day);

            StringBuilder builder = new StringBuilder();

            int numberOfNames = strings.length - 3;
            for (int i = 0; i < numberOfNames; i++)
            {
                builder.append(" ").append(strings[i]);
            }

            String name = builder.toString().trim();
            PEOPLE.add(new Person(name, date.getTime()));
        }

    }
}
