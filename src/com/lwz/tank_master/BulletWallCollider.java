package com.lwz.tank_master;

import java.util.Random;

public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(Object o1, Object o2) {
        if(o1 instanceof Bullet && o2 instanceof Wall){
            Bullet o11 = (Bullet) o1;
            Wall o21 = (Wall) o2;
            if(o11.rect.intersects(o21.rect)){
                o11.die();
            }
            return true;
        }else
        if(o2 instanceof Bullet && o1 instanceof Wall) {
            collide(o2,o1);
        }else
        if(o1 instanceof TankClass && o2 instanceof Wall){
            TankClass o11 = (TankClass) o1;
            Wall o21 = (Wall) o2;
            if(o11.rect.intersects(o21.rect)){
                Random random=new Random();
                o11.back();
                if (random.nextInt(100) > 95) o11.setDir(TankProp.values()[random.nextInt(8)]);
//                o11.setDir(TankProp.values()[random.nextInt(8)]);
                System.out.println(o21.rect.x+o21.rect.y);
//                Random random=new Random();
//                o11.setDir(TankProp.values()[random.nextInt(8)]);

            }
            return true;
        }else
        if(o2 instanceof Tank && o1 instanceof Wall) {
            collide(o2,o1);
        }
        return false;
    }
}
