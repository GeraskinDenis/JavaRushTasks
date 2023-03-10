package com.javarush.games.snake;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class Apple extends GameObject
{
    private static final String APPLE_SIGN = "\uD83C\uDF4E";

    public void draw(Game game)
    {
        game.setCellValueEx(x, y, Color.NONE, APPLE_SIGN, Color.RED, 75);
    }

    public Apple(int x, int y)
    {
        super(x, y);
    }
}
