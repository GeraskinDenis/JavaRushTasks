package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
        if (args.length == 0)
            return;

        String command = args[0];

        switch (command)
        {
            case "-c":
            {
                String name = args[1];

                Date date;
                try
                {
                    date = new SimpleDateFormat("d/MM/yyyy").parse(args[3]);
                } catch (ParseException e)
                {
                    e.printStackTrace();
                    return;
                }

                Person person;
                if (args[2].equalsIgnoreCase("м"))
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
                break;
            }
            case "-r":
            {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                String sex = (person.getSex() == Sex.MALE) ? "м" : "ж";
                SimpleDateFormat dataFormat = new SimpleDateFormat("d-MMM-yyyy", Locale.US);
                System.out.println(person.getName() + " " + sex + " " + dataFormat.format(person.getBirthDate()));
                break;
            }
            case "-u":
            {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(args[2]);

                Sex sex = (args[3].equalsIgnoreCase("м")) ? Sex.MALE : Sex.FEMALE;
                person.setSex(sex);

                Date date;
                try
                {
                    date = new SimpleDateFormat("d/MM/yyyy").parse(args[4]);
                } catch (ParseException e)
                {
                    e.printStackTrace();
                    return;
                }
                person.setBirthDate(date);
                break;
            }
            case "-d":
            {
                int id = Integer.parseInt(args[1]);
                Person person = allPeople.get(id);
                person.setBirthDate(null);
                person.setSex(null);
                person.setName(null);
                break;
            }
            default:
            {
                return;
            }
        }
    }
}
