package com.javarush.games.game2048;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class Game2048 extends Game
{
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize()
    {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame()
    {
        createNewNumber();
        createNewNumber();
    }

    private void drawScene()
    {
        for (int x = 0; x < SIDE; x++)
        {
            for (int y = 0; y < SIDE; y++)
            {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private void createNewNumber()
    {
        while (true)
        {
            int x = getRandomNumber(SIDE);
            int y = getRandomNumber(SIDE);
            if (gameField[x][y] != 0)
                continue;
            int randomNumber = getRandomNumber(10);
            gameField[x][y] = (randomNumber == 9) ? 4 : 2;
            break;
        }
    }

    private Color getColorByValue(int value)
    {
        switch (value)
        {
            case 0:
            {
                return Color.LIGHTGREY;
            }
            case 2:
            {
                return Color.YELLOW;
            }
            case 4:
            {
                return Color.ORANGE;
            }
            case 8:
            {
                return Color.DARKORANGE;
            }
            case 16:
            {
                return Color.GREEN;
            }
            case 32:
            {
                return Color.DARKGREEN;
            }
            case 64:
            {
                return Color.BLUE;
            }
            case 128:
            {
                return Color.DARKBLUE;
            }
            case 256:
            {
                return Color.RED;
            }
            case 512:
            {
                return Color.DARKRED;
            }
            case 1024:
            {
                return Color.VIOLET;
            }
            case 2048:
            {
                return Color.DARKVIOLET;
            }
            default:
                return Color.BLACK;
        }
    }

    private void setCellColoredNumber(int x, int y, int value)
    {
        Color color = getColorByValue(value);
        setCellValueEx(x, y, color, (value != 0) ? Integer.toString(value) : "");
    }

    private boolean compressRow(int[] row)
    {
        boolean modified = false;
        for (int i = 0; i < row.length; i++)
        {
            if (row[i] == 0)
                continue;
            for (int j = 0; j < i; j++)
            {
                if (row[j] == 0)
                {
                    row[j] = row[i];
                    row[i] = 0;
                    modified = true;
                    break;
                }
            }
        }
        return modified;
    }
}
