package com.android.pong;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * Created by andrew on 3/21/15.
 */
public abstract class Entity {
    //    An entity uses a standard box to model the location of itself
    public int x;
    public int y;
    public int width;
    public int height;
    protected Paint paint;

    public Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point getPosition() {
        return new Point(x, y);
    }

    public abstract void draw(Canvas c);

    public static boolean checkCollision(Entity p1, Entity p2) {
        Point a = p1.getPosition(), b = p2.getPosition();
        if (b.x >= a.x && b.x <= a.x + p1.width) {
            if (Math.abs(a.y - b.y) < 5) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
}
