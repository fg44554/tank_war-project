package com.lwz.tank_master;

import java.awt.*;

public class Explode extends GameObjects {
    private Integer x, y;
    private boolean live = true;
    private int step = 0;


    public Explode(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        new Thread(() -> new Audio("audio/explode.wav").play()).start();

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);

        if (step >= ResourceMgr.explodes.length) {
            Tank_model.getInstance().gameObjects.remove(this);
        }
    }


}
