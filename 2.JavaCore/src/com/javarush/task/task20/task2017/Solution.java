package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/

public class Solution
{
    public A getOriginalObject(ObjectInputStream objectStream)
    {
        try
        {
            A loadedObject = (A) objectStream.readObject();
            return loadedObject;
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public class A implements Serializable
    {
    }

    public class B extends A
    {
        public B()
        {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args)
    {

    }
}
