package com.javarush.task.pro.task11.task1109;

/*
Объекты внутренних и вложенных классов
*/

public class Solution {
    public static void main(String[] args) {

        Outer outer1 = new Outer();
        Outer.Inner inner1 = outer1.new Inner() ;
        Outer.Nested nested1 = new Outer.Nested();
    }
}
