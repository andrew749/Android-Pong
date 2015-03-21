package com.android.pong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by andrew on 3/21/15.
 */
public class Ball extends Entity {
    private int radius;
    public Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        radius=height;
        radius=width;
        paint=new Paint();
        paint.setColor(Color.RED);

    }
    @Override
    public void draw(Canvas c) {
        c.drawCircle(x,y,radius,paint);
    }
}
