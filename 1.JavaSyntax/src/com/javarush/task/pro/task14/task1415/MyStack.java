package com.javarush.task.pro.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Стек в домашних условиях
*/

public class MyStack
{

    private final List<String> storage = new ArrayList<>();

    public void push(String s)
    {
        storage.add(0, s);
    }

    public String pop()
    {
        String result;
        if (!storage.isEmpty())
            return storage.remove(0);
        return null;
    }

    public String peek()
    {
        if (!storage.isEmpty())
            return storage.get(0);
        return null;
    }

    public boolean empty()
    {
        return storage.isEmpty();
    }

    public int search(String s)
    {
        return storage.indexOf(s);
    }
}
