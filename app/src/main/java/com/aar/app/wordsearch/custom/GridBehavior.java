package com.aar.app.wordsearch.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.aar.app.wordsearch.R;

public abstract class GridBehavior extends View {

    private int mGridWidth = 100;
    private int mGridHeight = 100;

    public GridBehavior(Context context) {
        super(context);
        init(context, null);
    }

    public GridBehavior(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public int getGridWidth() {
        return (int) (100 * getScaleX());
    }

    public int getGridHeight() {
        return (int) (100 * getScaleY());
    }

    public abstract int getColCount();

    public abstract int getRowCount();

    public int getRequiredWidth() {
        return getPaddingLeft() + getPaddingRight() + ((10) * getGridWidth());
    }

    public int getRequiredHeight() {
        return getPaddingTop() + getPaddingBottom() + (10 * getGridHeight());
    }

    public int getColIndex(int screenPos) {
        return Math.max( Math.min((screenPos - getPaddingLeft()) / getGridWidth(), 9), 0 );
    }


    public int getRowIndex(int screenPos) {
        return Math.max( Math.min((screenPos - getPaddingTop()) / getGridHeight(), 9), 0 );
    }

    public int getCenterColFromIndex(int cIdx) {
        return (Math.min(Math.max(0, cIdx), 9) * 100) +
                (50) + getPaddingLeft();
    }

    public int getCenterRowFromIndex(int rIdx) {
        return (Math.min(Math.max(0, rIdx), 9) * 100) +
                (50) + getPaddingTop();
    }

    public void setGridWidth(int gridWidth) {
        mGridWidth = gridWidth;
        invalidate();
    }

    public void setGridHeight(int gridHeight) {
        mGridHeight = gridHeight;
        invalidate();
    }

    public abstract void setColCount(int colCount);

    public abstract void setRowCount(int rowCount);

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int measuredWidth = getRequiredWidth();
        int measuredHeight = getRequiredHeight();

        if (widthMode == MeasureSpec.EXACTLY)
            measuredWidth = width;
        else if (widthMeasureSpec == MeasureSpec.AT_MOST)
            measuredWidth = Math.min(measuredWidth, width);

        if (heightMode == MeasureSpec.EXACTLY)
            measuredHeight = height;
        else if (heightMode == MeasureSpec.AT_MOST)
            measuredHeight = Math.min(measuredHeight, height);

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    private void init(Context context, AttributeSet attrs) {
        mGridWidth = 100;
        mGridHeight = 100;

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GridBehavior, 0, 0);

            mGridWidth = a.getDimensionPixelSize(R.styleable.GridBehavior_gridWidth, mGridWidth);
            mGridHeight = a.getDimensionPixelSize(R.styleable.GridBehavior_gridHeight, mGridHeight);

            a.recycle();
        }
    }
}
