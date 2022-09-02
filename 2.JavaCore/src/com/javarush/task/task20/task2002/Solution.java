package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
//            File yourFile = File.createTempFile("your_file_name", null);
            File yourFile = new File("c:\\!tmp\\task2002.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user = new User();
            user.setBirthDate(new GregorianCalendar(1982, Calendar.DECEMBER, 22).getTime());
            user.setCountry(User.Country.RUSSIA);
            user.setFirstName("Anton");
            user.setMale(true);
            user.setLastName("Ivanov");
            javaRush.users.add(user);

            user = new User();
            user.setBirthDate(new GregorianCalendar(1990, Calendar.JULY, 11).getTime());
            user.setCountry(User.Country.UKRAINE);
            user.setFirstName("Elena");
            user.setMale(false);
            user.setLastName("Mironova");
            javaRush.users.add(user);

            javaRush.save(outputStream);

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            String lineSeparator = System.lineSeparator();
            StringBuilder builder = new StringBuilder();
            users.forEach(e ->
            {
                builder.append(String.format("%s;%s;%d;%s;%s",
                                e.getFirstName(),
                                e.getLastName(),
                                e.getBirthDate().getTime(),
                                (e.isMale()) ? "male" : "female",
                                e.getCountry()))
                        .append(lineSeparator);
            });
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            reader.lines()
                    .forEach(s ->
                    {
                        String[] valuesOfFields = s.split(";");
                        if (valuesOfFields.length == 5)
                        {
                            User user = new User();
                            user.setFirstName(valuesOfFields[0]); // firstname
                            user.setLastName(valuesOfFields[1]); // lastName
                            user.setBirthDate(new Date(Long.parseLong(valuesOfFields[2]))); // birthDate
                            user.setMale(valuesOfFields[3].equals("male")); // isMale
                            user.setCountry(User.Country.valueOf(valuesOfFields[4])); // country
                            users.add(user);
                        }
                    });
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode()
        {
            return users != null ? users.hashCode() : 0;
        }
    }
}
