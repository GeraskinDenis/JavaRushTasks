package com.javarush.games.minigames.mini04;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/* 
Считаем клетки
*/

public class CountGame extends Game
{

    @Override
    public void initialize()
    {
        setScreenSize(10, 10);
        showGrid(false);
        for (int j = 0; j < 50; j++)
        {
            int x = getRandomNumber(10);
            int y = getRandomNumber(10);
            setCellColor(x, y, Color.GREEN);
            setCellNumber(x, y, getRandomNumber(100));
        }
        showResult();
    }

    public void showResult()
    {
        int sumOfGreenCells = 0;
        int countOfGreenCells = 0;
        for (int x = 0; x < getScreenWidth(); x++)
        {
            for (int y = 0; y < getScreenHeight(); y++)
            {
                if (getCellColor(x, y) == Color.GREEN)
                {
                    countOfGreenCells++;
                    sumOfGreenCells += getCellNumber(x, y);
                }
            }
        }
        printSum(sumOfGreenCells);
        printCountOfGreenCells(countOfGreenCells);

    }

    private void printSum(int sum)
    {
        System.out.println("Сумма всех чисел = " + sum);
    }

    private void printCountOfGreenCells(int count)
    {
        System.out.println("Количество зеленых клеток = " + count);
    }
}
