package com.example.RunSquare;

import android.graphics.Rect;

public class Player{

    private Rect rect;

    public Player(int x, int y, int wight, int height)
    {
        this.rect = new Rect(x, y, x+wight, y+height);
    }

    public void Move(int x, int y)
    {
        rect.set(new Rect(x, y, x + rect.width(), y + rect.height()));
    }

    public Rect getRect() {
        return rect;
    }
}
