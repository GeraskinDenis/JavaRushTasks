package com.javarush.task.task14.task1404;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* 
Коты
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        List<Cat> catList = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in))
        {
            while (scanner.hasNextLine())
            {
                String str = scanner.nextLine();
                if(str.isEmpty())
                    break;
                catList.add(CatFactory.getCatByKey(str));
            }
        } catch (NoSuchElementException e)
        {
            e.printStackTrace();
            return;
        }

        catList.forEach(System.out::println);
    }

    static class CatFactory
    {
        static Cat getCatByKey(String key)
        {
            Cat cat;
            switch (key)
            {
                case "vaska":
                    cat = new MaleCat("Василий");
                    break;
                case "murka":
                    cat = new FemaleCat("Мурочка");
                    break;
                case "kiska":
                    cat = new FemaleCat("Кисюлька");
                    break;
                default:
                    cat = new Cat(key);
                    break;
            }
            return cat;
        }
    }

    static class Cat
    {
        private String name;

        protected Cat(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return this.name;
        }

        public String toString()
        {
            return "Я уличный кот " + getName();
        }
    }

    static class MaleCat extends Cat
    {
        MaleCat(String name)
        {
            super(name);
        }

        public String toString()
        {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat
    {
        FemaleCat(String name)
        {
            super(name);
        }

        public String toString()
        {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}
