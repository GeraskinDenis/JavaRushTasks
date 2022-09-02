package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        String file = ".\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\file_task2014.data";

        Solution savedObject = new Solution(40);
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(savedObject);
        objectOutputStream.close();
        outputStream.close();

        Solution loadObject = new Solution(10);
        FileInputStream inputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        loadObject = (Solution) objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();

        System.out.println(savedObject.string.equals(loadObject.string));
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature)
    {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString()
    {
        return this.string;
    }
}
