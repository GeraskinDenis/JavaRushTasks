package com.javarush.task.task20.task2021;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.Serializable;

/* 
Сериализация под запретом
*/

public class Solution implements Serializable
{
    public static class SubSolution extends Solution
    {
        private void writeObject(java.io.ObjectOutputStream out) throws IOException
        {
            throw new NotSerializableException();
        }

        private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
        {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args)
    {

    }
}
