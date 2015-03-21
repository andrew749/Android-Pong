package com.android.pong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by andrew on 3/21/15.
 */
public class Paddle extends Entity {
    public Paddle(int x, int y, int w, int h) {
        super(x, y,w,h);
        paint=new Paint();
        paint.setColor(Color.BLUE);
    }

    @Override
    public void draw(Canvas c) {
        c.drawRect(x,y,width,height,paint);
    }
}
