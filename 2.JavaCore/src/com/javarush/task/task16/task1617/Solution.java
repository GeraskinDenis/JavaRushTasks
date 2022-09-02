package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution
{
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException
    {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread
    {
        public RacingClock()
        {
            start();
        }

        public void run()
        {
            while (!isInterrupted() && numSeconds > 0)
            {
                System.out.print(numSeconds + " ");
                try
                {
                    Thread.sleep(1000); //  метод "interrupt()" вызван в момент "sleep()", что привело к "InterruptedException"
                    numSeconds--;
                } catch (InterruptedException e)
                {
                    interrupt();
                    System.out.print("Прервано!");
                }
            }
            if (!Thread.currentThread().isInterrupted())
                System.out.print("Марш!");
        }
    }
}
