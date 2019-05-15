package com.aar.app.wordsearch.commons;

import android.graphics.Color;

import java.util.List;
import java.util.Random;


public class Util {
    public static final char NULL_CHAR = '\0';

    private static Random sRand = new Random();

    public static int getRandomColorWithAlpha(int alpha) {
        int r = getRandomInt() % 256;
        int g = getRandomInt() % 256;
        int b = getRandomInt() % 256;
        return Color.argb(alpha, r, g, b);
    }

    public static char getRandomChar() {
        // ASCII A = 65 - Z = 90
        return (char) getRandomIntRange(65, 90);
    }
    public static int getRandomIntRange(int min, int max) {
        return min + (getRandomInt() % ((max - min) + 1));
    }

    public static int getRandomInt() {
        return Math.abs(sRand.nextInt());
    }

    public static int getIndexLength(GridIndex start, GridIndex end) {
        int x = Math.abs(start.col - end.col);
        int y = Math.abs(start.row - end.row);
        return Math.max(x, y) + 1;
    }

    public static <T> void randomizeList(List<T> list) {
        int count = list.size();
        for (int i = 0; i < count; i++) {
            int randIdx = getRandomIntRange(Math.min(i + 1, count - 1), count - 1);
            T temp = list.get(randIdx);
            list.set(randIdx, list.get(i));
            list.set(i, temp);
        }
    }

    public static String getReverseString(String str) {
        StringBuilder out = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--)
            out.append(str.charAt(i));

        return out.toString();
    }

    public static void fillNullCharWidthRandom(char[][] gridArr) {
        for (int i = 0; i < gridArr.length; i++) {
            for (int j = 0; j < gridArr[i].length; j++) {
                if (gridArr[i][j] == NULL_CHAR)
                    gridArr[i][j] = getRandomChar();
            }
        }
    }


}
