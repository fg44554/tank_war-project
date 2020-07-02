package com.lwz.tank_master;

public interface Tank<T> {
    public void fire(Tank<T> tank, Fire<T> fire);

//    public void fireMain(Tank<T> tank,  Fire<T> fire);

}
