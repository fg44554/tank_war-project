package com.lwz.tank_master;

import java.util.Random;

public class TankWallCollider implements Collider {
    @Override
    public boolean collide(Object o1, Object o2) {
        if(o1 instanceof TankClass && o2 instanceof Wall){
            TankClass o11 = (TankClass) o1;
            Wall o21 = (Wall) o2;
            if(o11.rect.intersects(o21.rect)){
                o11.back();
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
