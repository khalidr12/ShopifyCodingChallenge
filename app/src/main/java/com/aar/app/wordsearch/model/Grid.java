package com.aar.app.wordsearch.model;


public class Grid {
    public static final char GRID_NEWLINE_SEPARATOR = ',';
    private static final char NULL_CHAR = '\0';

    private char[][] mArray;

    public Grid(char[][] grid) {
        mArray = grid;
    }

    public Grid(int rowCount, int colCount) {
        if (rowCount <= 0 || colCount <= 0)
            throw new IllegalArgumentException("Row and column should be greater than 0");
        mArray = new char[rowCount][rowCount];
        reset();
    }

    public int getRowCount() {
        return mArray.length;
    }

    public int getColCount() {
        return mArray[0].length;
    }

    public char[][] getArray() {
        return mArray;
    }

    private char at(int row, int col) {
        return mArray[row][col];
    }


    private void reset() {
        for (int i = 0; i < mArray.length; i++) {
            for (int j = 0; j < mArray[i].length; j++) {
                mArray[i][j] = NULL_CHAR;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                stringBuilder.append(at(i, j));
            }

            if (i != 9)
                stringBuilder.append(GRID_NEWLINE_SEPARATOR);
        }

        return stringBuilder.toString();
    }
}
