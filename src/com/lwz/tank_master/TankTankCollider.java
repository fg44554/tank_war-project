package com.lwz.tank_master;

public class TankTankCollider implements Collider {

    @Override
    public boolean collide(Object o1, Object o2) {
        if (o1 instanceof TankClass && o2 instanceof TankClass) {
            TankClass o11 = (TankClass) o1;
           TankClass o21 = (TankClass) o2;
            if (o21.getRect().intersects(o11.getRect())) {
                o21.die();
                o11.die();
                return false;
            }
        }
        return true;
    }
}
