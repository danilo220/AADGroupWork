package com.aadgroup.aadgroupwork;

import android.content.Context;
import android.graphics.Color;

public class Tile extends android.support.v7.widget.AppCompatImageButton {
    private int numberOfDots;
    private Boolean isActive = false;

    public Tile(Context context, int numberOfDots) {
        super(context);
        this.numberOfDots = numberOfDots;
        this.setBackgroundColor(Color.TRANSPARENT);
    }

    public int getNumberOfDots()
    {
        return numberOfDots;
    }

    public Boolean toggleActive()
    {
        isActive = !isActive;
        if (isActive)
        {
            this.setBackgroundColor(Color.GREEN);
        }
        else
        {
            this.setBackgroundColor(Color.TRANSPARENT);
        }
        return isActive;
    }
}
