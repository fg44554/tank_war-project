package com.lwz.tank_master;

import java.awt.*;

import static com.lwz.tank_master.TankRun.GAME_HEIGHT;
import static com.lwz.tank_master.TankRun.GAME_WIDTH;

public class BOMB extends GameObjects {
    private Integer speed;

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    private Integer x, y;
    private TankProp dir;

    private boolean live = true;
    public static Integer HEIGHT = ResourceMgr.BOMBU.getHeight();
    public static Integer WIDTH = ResourceMgr.BOMBU.getWidth();

    public BOMB(Integer x, Integer y, TankProp dir, Integer speed) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.speed = speed;

    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();

        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.BOMBU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.BOMBU, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.BOMBU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.BOMBU, x, y, null);
                break;
            case UL:
                g.drawImage(ResourceMgr.BOMBU, x, y, null);
                break;
            case UR:
                g.drawImage(ResourceMgr.BOMBU, x, y, null);
                break;
            case DL:
                g.drawImage(ResourceMgr.BOMBU, x, y, null);
                break;
            case DR:
                g.drawImage(ResourceMgr.BOMBU, x, y, null);
                break;
            default:
                g.drawImage(ResourceMgr.BOMBU, x, y, null);
                break;
        }

        move();
        if (!live) {
          Tank_model.getInstance().gameObjects.remove(this);
            Tank_model.bombCount--;
        }
    }


    public void move() {
        switch (dir) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UL:
                y -= speed;
                x -= speed;
                break;
            case UR:
                y -= speed;
                x += speed;
                break;
            case DL:
                y += speed;
                x -= speed;
                break;
            case DR:
                y += speed;
                x += speed;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > GAME_WIDTH || y > GAME_HEIGHT) live = false;


        //如果这句不启用会产生一个不起眼的bug
//        if(x<0||y<0||x>GAME_WIDTH||y>GAME_HEIGHT)live=false;
    }


    public void die() {
        Tank_model.getInstance().gameObjects.remove(this);
        Tank_model.bombCount--;

    }
}
