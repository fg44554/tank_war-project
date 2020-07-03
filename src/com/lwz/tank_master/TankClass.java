package com.lwz.tank_master;

import jdk.dynalink.beans.StaticClass;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TankClass extends GameObjects implements Tank {


    public Integer x;
    public Integer y;
    private Integer speed;
    private TankProp dir;
    int OldX;
    int OldY;
    int Blood=Integer.parseInt((String) PropMgr.get("Blood"));

    public TankProp getDir() {
        return dir;
    }

    private boolean moving = true;
    //    private TankRun tankRun=null;
    public static Integer WIDTH = ResourceMgr.goodtankD.getWidth();
    public static Integer HEIGHT = ResourceMgr.goodtankD.getHeight();
    Rectangle rect = new Rectangle();

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setX(Integer x) {
        this.x = x;
    }


    public void setY(Integer y) {
        this.y = y;
    }

    private Group group = Group.BAD;
    Random random = new Random();

    public TankClass() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public TankClass(Integer x, Integer y, Integer speed, TankProp dir, Group group) {
        this.y = y;
        this.x = x;
        this.speed = speed;
        this.dir = dir;
        this.group = group;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }
    public  void setBlood(){
        this.Blood-=1;
    }
    public int getBlood(){
        return Blood;
    }
    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setDir(TankProp dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        switch (dir) {
            case UP:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badtankU : ResourceMgr.goodtankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badtankD : ResourceMgr.goodtankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badtankL : ResourceMgr.goodtankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badtankR : ResourceMgr.goodtankR, x, y, null);
                break;
            case UL:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badtankLU : ResourceMgr.goodtankLU, x, y, null);
                break;
            case UR:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badtankRU : ResourceMgr.goodtankRU, x, y, null);
                break;
            case DL:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badtankLD : ResourceMgr.goodtankLD, x, y, null);
                break;
            case DR:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badtankRD : ResourceMgr.goodtankRD, x, y, null);
                break;
            default:
                break;
        }
        move();
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire(this, new Fire() {
                @Override
                public void openfire(Tank tank) {
                    TankClass t = (TankClass) tank;
                    //重复new可以一次发射多个子弹，角度和速度可调节
                    int bx = t.x + TankClass.WIDTH / 2 - Bullet.WIDTH / 2;
                    int by = t.y + TankClass.HEIGHT / 2 - Bullet.HEIGHT / 2;
                    Tank_model.getInstance().gameObjects.add(new Bullet(bx, by, t.dir, 2, t.group));
                    Tank_model.bulletCount++;

                }

//                @Override
//                public void openFire(Tank tank, Tank_model tm) {
//
//                }
            });
        }
        randomDir();
    }


    public void collisionWall() {
//        if(this.group==Group.BAD){
        if (this.x < 2) {
            this.dir = TankProp.RIGHT;
            this.x = 2;
        }
        if (this.y < 30) {
            this.dir = TankProp.DOWN;
            this.y = 30;
        }
        if (this.x > TankRun.GAME_WIDTH - 30) {
            this.dir = TankProp.LEFT;
            this.x = TankRun.GAME_WIDTH - 30;
        }
        if (this.y > TankRun.GAME_HEIGHT - 30) {
            this.dir = TankProp.UP;
            this.y = TankRun.GAME_HEIGHT - 30;
        }
    }

    private void randomDir() {
        if (this.group == Group.BAD && random.nextInt(100) > 98)
            this.dir = TankProp.values()[random.nextInt(8)];
    }
    public void back() {
        x = OldX;
        y = OldY;
    }
    public void move() {
        OldX=this.x;
        OldY=this.y;
        if (!moving) return;
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
        collisionWall();
        rect.x = this.x;
        rect.y = this.y;
//        if(random.nextInt(10)>8)this.fire();
    }

    public Rectangle getRect() {
        return rect;
    }

    @Override
    public void fire(Tank tank, Fire fire) {
        fire.openfire(tank);

//        tankRun.bullets.add(new Bullet(this.x-24,this.y+24,this.dir,tankRun,2,this.group));
//        tankRun.bullets.add(new Bullet(this.x+24,this.y-24,this.dir,tankRun,2,this.group));
    }


    public void bomb() {

    }

    public void die() {
        if(this.getGroup()==Group.GOOD){
            if(this.getBlood()==0){
                Tank_model.getInstance().gameObjects.remove(this);
                Tank_model.tankCount--;
                Tank_model.getInstance().gameObjects.add(new Explode(this.x, this.y));
            }else{
                this.setBlood();
            }
        }else {
        Tank_model.getInstance().gameObjects.remove(this);
        Tank_model.tankCount--;
        Tank_model.getInstance().gameObjects.add(new Explode(this.x, this.y));
        }

    }
    private List<TankFireHandler> aa=  Arrays.asList(new TankFireHandler());
    public void fireHandle(){
        Event event = new Event(this);
        for (int i = 0; i <aa.size() ; i++) {
            aa.get(i).tankFireHandle(event);
        }
    }

}
