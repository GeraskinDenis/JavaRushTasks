package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution
{

    public static void main(String[] args) throws IOException
    {
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner("Иванов Иван Иванович 31 12 1950"));
        System.out.println(personScannerAdapter.read());
        personScannerAdapter.close();
    }

    public static class PersonScannerAdapter implements PersonScanner
    {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner)
        {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException
        {
            String s = fileScanner.nextLine();
            String[] strings = s.split(" ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

//            Calendar calendar = new GregorianCalendar(Integer.parseInt(split[5]), Integer.parseInt(split[4]) - 1, Integer.parseInt(split[3]));
//            Date date = calendar.getTime();

            Date date = null;
            try
            {
                date = dateFormat.parse(strings[5] + strings[4] + strings[3]);
            } catch (ParseException e)
            {
                e.printStackTrace();
            }
//            return new Person(strings[1], strings[0], strings[2], date); // ОШИБКА ВАЛИДАТОРА
            return new Person(strings[1], strings[2], strings[0], date);
        }

        @Override
        public void close() throws IOException
        {
            fileScanner.close();
        }
    }
}
