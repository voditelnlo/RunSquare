package com.example.RunSquare;

import java.util.ArrayList;

public class GameState {
    private int fieldWight;
    private int fieldHeight;

    private Player player;

    private ArrayList <Bot>bots;

    private boolean game;

    public GameState(int fieldWight, int fieldHeight, int botsCount)
    {
        this.player = new Player(0,0,10,10);

        this.game = false;

        this.fieldWight = fieldWight;
        this.fieldHeight = fieldHeight;

        for(int i = 0; i < botsCount; i++)
        {
            Bot tmpBot;

            do
            {
                tmpBot = new Bot((int) (Math.random() * fieldWight), (int) (Math.random() * fieldHeight), 10, 10, 1, 1);
            }
            while(Validate(tmpBot));

            bots.add(tmpBot);
        }
    }

    public void MovePlayer(int x, int y) {
        player.Move(x, y);
        MoveValidate();
    }

    public void MoveBots() {

        for(Bot item:bots)
        {
            Bot tmpBot = new Bot(item);
            tmpBot.Move();

            if(tmpBot.getRect().left < 0 || tmpBot.getRect().right > fieldWight){
                item.reflectVertical();
            }

            if(tmpBot.getRect().top < 0 || tmpBot.getRect().bottom > fieldHeight){
                item.reflectHorizontal();
            }

            item.Move();
        }

        MoveValidate();
    }

    public boolean isGame() {
        return game;
    }

    public void setGame(boolean game) {
        this.game = game;
    }

    private boolean Validate(Bot bot)
    {
        boolean crossX = false;
        boolean crossY = false;

        if(player.getRect().left > bot.getRect().left && player.getRect().left < bot.getRect().right)
        {
            crossX = true;
        }

        if(player.getRect().right > bot.getRect().left && player.getRect().right < bot.getRect().right)
        {
            crossX = true;
        }

        if(player.getRect().top > bot.getRect().top && player.getRect().top < bot.getRect().bottom)
        {
            crossY = true;
        }

        if(player.getRect().bottom > bot.getRect().top && player.getRect().bottom < bot.getRect().bottom)
        {
            crossY = true;
        }

        return crossX && crossY;
    }

    private void MoveValidate()
    {
        for(Bot item:bots)
        {
            if(!Validate(item))
            {
                game = false;
            }
        }
    }
}
