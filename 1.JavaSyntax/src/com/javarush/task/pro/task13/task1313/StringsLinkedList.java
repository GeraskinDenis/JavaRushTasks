package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList
{
    private Node first = new Node();
    private Node last = new Node();

    public void printAll()
    {
        Node currentElement = first.next;
        while ((currentElement) != null)
        {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value)
    {
        Node newNode = new Node();
        newNode.value = value;

        newNode.next = last;
        if (last.prev != null)
        {
            newNode.prev = last.prev;
            newNode.prev.next = newNode;
        } else
        {
            first.next = newNode;
            newNode.prev = first;
        }
        last.prev = newNode;
    }

    public static class Node
    {
        private Node prev;
        private String value;
        private Node next;
    }
}
