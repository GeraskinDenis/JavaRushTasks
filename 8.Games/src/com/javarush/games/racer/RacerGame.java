package com.javarush.games.racer;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class RacerGame extends Game
{
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;

    @Override
    public void initialize()
    {
        setScreenSize(WIDTH, HEIGHT);
        showGrid(false);
        createGame();
    }

    private void createGame()
    {
        drawScene();
    }

    private void drawScene()
    {
        drawField();
    }

    private void drawField()
    {
        Color color;
        for (int y = 0; y < HEIGHT; y++)
        {
            for (int x = 0; x < WIDTH; x++)
            {
                if ((x >= 0 && x < ROADSIDE_WIDTH) || (x >= WIDTH - ROADSIDE_WIDTH && x <= WIDTH))
                {
                    color = Color.GREEN;
                } else if ((x >= ROADSIDE_WIDTH && x < WIDTH - ROADSIDE_WIDTH && x != CENTER_X))
                {
                    color = Color.DIMGRAY;
                } else
                {
                    color = Color.WHITE;
                }
                setCellColor(x, y, color);
            }
        }
    }
}
