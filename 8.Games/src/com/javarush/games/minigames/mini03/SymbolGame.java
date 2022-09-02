package com.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/* 
Простая программа
*/

public class SymbolGame extends Game
{
    @Override
    public void initialize()
    {
        setScreenSize(8, 3);
        String[] strArr = "JAVARUSH".split("");
        int x = 0;
        for (String oneStr : strArr)
        {
            setCellValueEx(x++, 1, Color.ORANGE, oneStr);
        }
    }
}
