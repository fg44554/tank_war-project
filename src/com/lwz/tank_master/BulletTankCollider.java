package com.lwz.tank_master;

import java.awt.*;

public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(Object o1, Object o2) {
        if (o1 instanceof TankClass && o2 instanceof Bullet) {
            TankClass o11 = (TankClass) o1;
            Bullet o21 = (Bullet) o2;
            if (o11.getGroup() == o21.getGroup()) {
                return true;
            }
            if (o21.getRect().intersects(o11.getRect())) {
                o21.die();
                o11.die();
                return false;
            }
        } else if (o2 instanceof TankClass && o1 instanceof Bullet) {
            collide(o2, o1);
        } else if (o1 instanceof BOMB && o2 instanceof TankClass) {
            TankClass o21 = (TankClass) o2;
            BOMB o11 = (BOMB) o1;
            Rectangle rect = new Rectangle(o11.getX(), o11.getY(), o11.WIDTH, o11.HEIGHT);
            if (rect.intersects(o21.getRect())) {
                o21.die();
                o11.die();
                return false;
            }
        } else if (o2 instanceof BOMB && o1 instanceof TankClass) {
            collide(o2, o1);
        }else if(o1 instanceof  BOMB && o2 instanceof  Bullet){
            BOMB o11 = (BOMB) o1;
            Bullet o21 = (Bullet) o2;
            if (o21.getGroup()==Group.GOOD) {
                return true;
            }
            Rectangle rect = new Rectangle(o11.getX(), o11.getY(), o11.WIDTH, o11.HEIGHT);
            if(rect.intersects(o21.rect)){
                o21.die();
                o11.die();
                return false;
            }
        }else if(o2 instanceof  BOMB && o1 instanceof  Bullet){
            collide(o2,o1);
        }
        return true;


    }
}
