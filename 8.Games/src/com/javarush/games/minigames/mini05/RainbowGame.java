package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/* 
Цвета радуги
*/

public class RainbowGame extends Game
{
    public static final int WIDTH = 10;
    public static final int HEIGHT = 7;

    @Override
    public void initialize()
    {
        setScreenSize(WIDTH, HEIGHT);
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.INDIGO, Color.VIOLET};
        for (int x = 0; x < WIDTH; x++)
        {
            for (int y = 0; y < HEIGHT; y++)
            {
                setCellColor(x, y, colors[y]);
            }
        }
    }
}
