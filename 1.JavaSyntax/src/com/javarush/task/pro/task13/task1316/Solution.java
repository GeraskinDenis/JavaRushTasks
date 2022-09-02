package com.javarush.task.pro.task13.task1316;

public class Solution {

    public static void main(String[] args) {
        JavarushQuest[] javarushQuestsArr = JavarushQuest.values();
        for (JavarushQuest quest : javarushQuestsArr)
        {
            System.out.println(quest.ordinal());
        }
    }
}
