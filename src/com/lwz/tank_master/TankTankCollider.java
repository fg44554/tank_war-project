package com.lwz.tank_master;

import java.util.Random;

public class TankTankCollider implements Collider {

    @Override
    public boolean collide(Object o1, Object o2) {
        if (o1 instanceof TankClass && o2 instanceof TankClass) {
            TankClass o11 = (TankClass) o1;
            TankClass o21 = (TankClass) o2;
            if (o21.getRect().intersects(o11.getRect())) {
                Random random=new Random();
                o11.back();
                if (random.nextInt(100) > 95) o11.setDir(TankProp.values()[random.nextInt(8)]);
                o21.back();
//                o21.setDir(TankProp.values()[random.nextInt(8)]);
                return false;
            }
        }
        return true;
    }
}
