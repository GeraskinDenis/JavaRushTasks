package com.javarush.games.minigames.mini07;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/* 
Работа с мышью
*/

public class PaintGame extends Game
{

    public static final int WIDTH = 5;
    public static final int HEIGHT = 5;

    @Override
    public void onMouseLeftClick(int x, int y)
    {
        setCellColor(x, y, Color.GREEN);
    }

    @Override
    public void onMouseRightClick(int x, int y)
    {
        setCellColor(x, y, Color.ORANGE);
    }

    @Override
    public void initialize()
    {
        setScreenSize(WIDTH, HEIGHT);
        for (int x = 0; x < WIDTH; x++)
        {
            for (int y = 0; y < HEIGHT; y++)
            {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }
}
