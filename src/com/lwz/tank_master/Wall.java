package com.lwz.tank_master;

import com.lwz.WallStrategy.WS1;
import com.lwz.WallStrategy.WallMod;

import java.awt.*;

public class Wall extends GameObjects {
    private int x,y;
    private int width;
    private int height;
    Rectangle rect = new Rectangle();
    public Wall(int x,int y,int width,int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        rect.x=this.x;
        rect.y=this.y;
        rect.width = this.width;
        rect.height = this.height;
    }

    @Override
    public void paint(Graphics g) {
        Color c=g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(this.x,this.y,this.width,this.height);
        g.setColor(c);
    }
    public void addWall(WallMod wallMod){
        wallMod.addWall();

    }
}
