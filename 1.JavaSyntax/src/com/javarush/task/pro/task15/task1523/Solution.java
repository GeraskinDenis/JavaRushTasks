package com.javarush.task.pro.task15.task1523;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException
    {
        URL url = new URL("http://httpbin.org/post");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);

        try(OutputStream outputStream = urlConnection.getOutputStream())
        {
            byte[] buffer = "Hello!".getBytes(StandardCharsets.UTF_8);
            outputStream.write(buffer);
        }

        try(InputStream inputStream = urlConnection.getInputStream())
        {
            byte[] buffer = inputStream.readAllBytes();
            System.out.println(new String(buffer));
        }
    }
}

