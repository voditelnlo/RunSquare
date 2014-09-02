package com.example.RunSquare;

import android.graphics.Rect;

public class Figure {

    private int speed;
    private double angle;

    private Rect rect;

    public Figure(int x, int y, int wight, int height, int speed, double angle) {
        this.speed = speed;
        this.angle = angle;
        this.rect = new Rect(x, y, x + wight, y + height);
    }

    public void SpeedIncrease() {
        speed++;
    }

    public void reflectVertical() {
        if (angle > 0 && angle < Math.PI)
            angle = Math.PI - angle;
        else
            angle = 3 * Math.PI - angle;
    }

    public void reflectHorizontal() {
        angle = 2 * Math.PI - angle;
    }

    public Rect getRect() {
        return rect;
    }

    public void Move()
    {
        int x = rect.left + (int)(speed*Math.sin(angle));
        int y = rect.top + (int)(speed*Math.cos(angle));
        rect.set(new Rect(x, y, x + this.rect.width(), y + this.rect.height()));
    }
}
