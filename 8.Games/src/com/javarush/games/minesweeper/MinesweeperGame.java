package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class MinesweeperGame extends Game
{
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField = 0;

    @Override
    public void initialize()
    {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame()
    {
        for (int y = 0; y < SIDE; y++)
        {
            for (int x = 0; x < SIDE; x++)
            {
                boolean isMine = (5 == getRandomNumber(10));
                if (isMine)
                    countMinesOnField++;
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
    }
}
