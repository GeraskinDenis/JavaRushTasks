package com.javarush.task.pro.task08.task0805;

import java.util.Random;

public class MagicBall
{
    private static final String CERTAIN = "Бесспорно";
    private static final String DEFINITELY = "Определённо да";
    private static final String MOST_LIKELY = "Вероятнее всего";
    private static final String OUTLOOK_GOOD = "Хорошие перспективы";
    private static final String ASK_AGAIN_LATER = "Спроси позже";
    private static final String TRY_AGAIN = "Попробуй снова";
    private static final String NO = "Мой ответ — нет";
    private static final String VERY_DOUBTFUL = "Весьма сомнительно";

    public static String getPrediction()
    {

        Random r = new Random();
        int randomInt = r.nextInt(8);
        if (randomInt == 0)
            return CERTAIN;
        else if (randomInt == 1)
            return DEFINITELY;
        else if (randomInt == 2)
            return MOST_LIKELY;
        else if (randomInt == 3)
            return OUTLOOK_GOOD;
        else if (randomInt == 4)
            return ASK_AGAIN_LATER;
        else if (randomInt == 5)
            return TRY_AGAIN;
        else if (randomInt == 6)
            return NO;
        else if (randomInt == 7)
            return VERY_DOUBTFUL;
        return null;
    }
}
