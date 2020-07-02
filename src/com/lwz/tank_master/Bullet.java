package com.lwz.tank_master;


import java.awt.*;

import static com.lwz.tank_master.TankRun.GAME_HEIGHT;
import static com.lwz.tank_master.TankRun.GAME_WIDTH;

public class Bullet extends GameObjects {
    private Integer speed;
    private Integer x, y;
    Rectangle rect = new Rectangle();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private TankProp dir;
    private boolean live = true;
    //    TankRun tr=null;
    private Group group = Group.BAD;
    public static Integer HEIGHT = ResourceMgr.bulletD.getHeight();
    public static Integer WIDTH = ResourceMgr.bulletD.getWidth();

    public Bullet(Integer x, Integer y, TankProp dir, Integer speed, Group group) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.group = group;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();

        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UL:
                g.drawImage(ResourceMgr.missileLU, x, y, null);
                break;
            case UR:
                g.drawImage(ResourceMgr.missileRU, x, y, null);
                break;
            case DL:
                g.drawImage(ResourceMgr.missileLD, x, y, null);
                break;
            case DR:
                g.drawImage(ResourceMgr.missileRD, x, y, null);
                break;
            default:
                break;
        }
        move();
        if (!live) {
            Tank_model.getInstance().gameObjects.remove(this);
            Tank_model.bulletCount--;
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
        rect.x = this.x;
        rect.y = this.y;
        if (x < 0 || y < 0 || x > GAME_WIDTH || y > GAME_HEIGHT) live = false;
    }

    public Rectangle getRect() {
        return rect;
    }


    public void die() {
        Tank_model.getInstance().gameObjects.remove(this);
        Tank_model.bulletCount--;
    }
}
