package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game
{
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;

    @Override
    public void initialize()
    {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame()
    {
        createStars();
        drawScene();
    }

    private void drawScene()
    {
        drawField();
    }

    private void drawField()
    {
        for (int y = 0; y < HEIGHT; y++)
        {
            for (int x = 0; x < WIDTH; x++)
            {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }

        stars.stream()
                .forEach(e -> e.draw(this));
    }

    private void createStars()
    {
        stars = new ArrayList<>();
        stars.add(new Star(61, 3));
        stars.add(new Star(51, 53));
        stars.add(new Star(41, 23));
        stars.add(new Star(31, 43));
        stars.add(new Star(21, 33));
        stars.add(new Star(11, 13));
        stars.add(new Star(11, 63));
        stars.add(new Star(57, 20));
    }
}
