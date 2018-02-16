package com.aadgroup.aadgroupwork;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import java.util.Random;

public class DrawView extends View {
    Paint paint = new Paint();
    Paint textPaint = new Paint();
    Context mContext;
    private int[] xCords;
    private int[] yCords;
    private boolean[] clicked = {false, false, false, false, false};
    private boolean set = false;
    private int currentNumber = 0;

    private void init() {
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        textPaint.setTextSize(100);
        textPaint.setColor(Color.BLUE);
    }

    public DrawView(Context context) {
        super(context);
        mContext = context;
        xCords = new int[5];
        yCords = new int[5];
        set = false;
        init();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public void onDraw(Canvas canvas) {
        if(set)
        {
            for(int i = 0; i < xCords.length; ++i)
            {
                if(clicked[i])
                {
                    Paint newPaint = new Paint();
                    newPaint.setColor(Color.YELLOW);
                    canvas.drawCircle(xCords[i], yCords[i], 100, newPaint);

                    if(i > 0)
                    {
                        canvas.drawLine(xCords[i], yCords[i], xCords[i-1], yCords[i-1], paint);
                    }
                }
            }
        }

        if(!set)
        {
            PathForming parent = (PathForming) mContext;
            Display display = parent.getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x - 200;
            double height = size.y;

            height = ((double)80/100) * height;
            Random r = new Random();

            for(int i = 0; i < 5; ++i)
            {
                int tempX = 0;
                int tempY = 0;

                if(i != 0)
                {
                    do {
                        tempX = r.nextInt(width) + 100;
                        tempY = r.nextInt((int) height) + 100;

                        boolean safe = true;

                        for(int j = 0; j < i; ++j)
                        {
                            int diffX = Math.abs(tempX - xCords[j]);
                            int diffY = Math.abs(tempY - yCords[j]);

                            if(diffX <= 100 || diffY <= 100)
                            {
                                safe = false;
                            }
                        }

                        if(safe)
                            break;

                    }while(true);
                }
                else
                {
                    tempX = r.nextInt(width) + 100;
                    tempY = r.nextInt((int) height);
                }

                xCords[i] = tempX;
                yCords[i] = tempY;
            }
            set();
        }

        for(int i = 1; i <= 5; ++i) {
            canvas.drawText(i + "", xCords[i - 1] - 20, yCords[i - 1] + 20, textPaint);
            canvas.drawCircle(xCords[i - 1], yCords[i - 1], 100, paint);
        }
    }

    public void setClicked(int pos)
    {
        clicked[pos] = true;
        currentNumber = pos;
    }

    public void set()
    {
        set = true;
    }

    public int[] getxCords()
    {
        return xCords;
    }

    public int[] getyCords()
    {
        return yCords;
    }
}