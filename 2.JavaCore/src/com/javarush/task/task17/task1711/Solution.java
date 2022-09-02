package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution
{
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
        if (args.length == 0 || args.length == 1)
            return;

        switch (args[0])
        {
            case "-c":
            {
                synchronized (allPeople)
                {
                    if ((args.length - 1) % 3 != 0)
                        return;

                    int numberOfElementsInGroup = 3;
                    int numberOfGroups = (args.length - 1) / numberOfElementsInGroup;

                    for (int i = 0; i < numberOfGroups; i++)
                    {
                        Person person;
                        String name = args[1 + (numberOfElementsInGroup * i)];

                        String strDate = args[3 + (numberOfElementsInGroup * i)];
                        Date date;
                        try
                        {
                            date = new SimpleDateFormat("d/MM/yyyy").parse(strDate);
                        } catch (ParseException e)
                        {
                            e.printStackTrace();
                            return;
                        }

                        String sex = args[2 + (numberOfElementsInGroup * i)];
                        if (sex.equalsIgnoreCase("м"))
                        {
                            person = Person.createMale(name, date);
                        } else if (args[2].equalsIgnoreCase("ж"))
                        {
                            person = Person.createFemale(name, date);
                        } else
                        {
                            return;
                        }

                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                    break;
                }
            }
            case "-i":
            {
                synchronized (allPeople)
                {
                    for (int i = 1; i < args.length; i++)
                    {
                        int id = Integer.parseInt(args[i]);
                        Person person = allPeople.get(id);
                        String sex = (person.getSex() == Sex.MALE) ? "м" : "ж";
                        SimpleDateFormat dataFormat = new SimpleDateFormat("d-MMM-yyyy", Locale.US);
                        System.out.println(person.getName() + " " + sex + " " + dataFormat.format(person.getBirthDate()));
                    }
                    break;
                }
            }
            case "-u":
            {
                synchronized (allPeople)
                {
                    if ((args.length - 1) % 4 != 0)
                        return;

                    int numberOfElementsInGroup = 4;
                    int numberOfGroups = (args.length - 1) / numberOfElementsInGroup;

                    for (int i = 0; i < numberOfGroups; i++)
                    {
                        // id
                        int id = Integer.parseInt(args[1 + (numberOfElementsInGroup * i)]);
                        // name
                        String name = args[2 + (numberOfElementsInGroup * i)];
                        // sex
                        String strSex = args[3 + (numberOfElementsInGroup * i)];
                        Sex sex = (strSex.equalsIgnoreCase("м")) ? Sex.MALE : Sex.FEMALE;
                        // birth date
                        String strDate = args[4 + (numberOfElementsInGroup * i)];
                        Date date;
                        try
                        {
                            date = new SimpleDateFormat("d/MM/yyyy", Locale.US).parse(strDate);
                        } catch (ParseException e)
                        {
                            e.printStackTrace();
                            return;
                        }
                        // update
                        Person person = allPeople.get(id);
                        person.setName(name);
                        person.setSex(sex);
                        person.setBirthDate(date);
                    }
                    break;
                }
            }
            case "-d":
            {
                synchronized (allPeople)
                {
                    for (int i = 1; i < args.length; i++)
                    {
                        int id = Integer.parseInt(args[i]);
                        Person person = allPeople.get(id);
                        person.setBirthDate(null);
                        person.setSex(null);
                        person.setName(null);
                    }
                    break;
                }
            }
        }
    }
}
