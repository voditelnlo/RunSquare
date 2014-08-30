package com.example.RunSquare;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class GameDraw extends View
{
    public GameDraw(Context context)
    {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        Paint paint = new Paint();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawPaint(paint);

        int fieldWidth = player.getMatrixWidth() + 1 + player.getNextFigure().getWidth() + 1;
        int fieldHeight = player.getMatrixHeight() + 1;

        int delta = this.getWidth() / fieldWidth;

        if (delta*fieldHeight > this.getHeight())
        {
            delta = this.getHeight() / fieldHeight;
        }

        int offsetX = (this.getWidth() - delta*fieldWidth) / 2;
        int offsetY = (this.getHeight() - delta*fieldHeight) / 2;

        if (player.getGameOver() && player.getScore() == 0)
        {
            paint.setColor(Color.WHITE);
            paint.setTextSize(this.getWidth() / 11);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("T E T R I S", this.getWidth()/2, this.getHeight()/2, paint);
            canvas.drawText("Tap to start", this.getWidth()/2, this.getHeight()/2 + 2*paint.getTextSize(), paint);
        }
        else
        {
            GameDraw(canvas, player, offsetX, offsetY, delta);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            float touchX = event.getX();
            float touchY = event.getY();
        }


        invalidate();

        return true;
    }

}
