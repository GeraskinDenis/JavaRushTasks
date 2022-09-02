package com.javarush.task.pro.task15.task1522;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        URL url;
        try
        {
            url =  new URL("https://javarush.ru/api/1.0/rest/projects");
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
            return;
        }

        try (InputStream iStream  = url.openStream())
        {
            byte[] buffer = iStream.readAllBytes();
            System.out.println(new String(buffer));
        }

    }
}