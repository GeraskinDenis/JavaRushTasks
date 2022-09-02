package com.javarush.task.pro.task10.task1016;

/* 
Прогноз погоды
*/

public class Solution
{

    public static void showWeather(City city)
    {

        System.out.printf("В городе %1s сегодня температура воздуха %2d", city.getName(), city.getTemperature());

    }

    public static void main(String[] args)
    {

        City city = new City("Дубай", 40);
        showWeather(city);

    }
}
