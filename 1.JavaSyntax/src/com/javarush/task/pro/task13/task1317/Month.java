package com.javarush.task.pro.task13.task1317;

/* 
Трансформируем enum в класс
*/

public class Month
{
    public final static Month JANUARY = new Month(0);
    public final static Month FEBRUARY = new Month(1);
    public final static Month MARCH = new Month(2);
    public final static Month APRIL = new Month(3);
    public final static Month MAY = new Month(4);
    public final static Month JUNE = new Month(5);
    public final static Month JULY = new Month(6);
    public final static Month AUGUST = new Month(7);
    public final static Month SEPTEMBER = new Month(8);
    public final static Month OCTOBER = new Month(9);
    public final static Month NOVEMBER = new Month(10);
    public final static Month DECEMBER = new Month(11);
    private final static Month[] months = {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
    private int index;

    private Month(int index)
    {
        this.index = index;
    }

    public static Month[] values()
    {
        return months;
    }

    public int ordinal()
    {
        return index;
    }
}
