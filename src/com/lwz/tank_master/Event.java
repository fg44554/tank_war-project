package com.lwz.tank_master;


import java.awt.event.KeyEvent;

public class Event {
   TankClass t=null;
    public TankClass getSource(){
        return t;
    }
    public Event(TankClass tankClass){
        this.t=tankClass;
    }
//    public void eventHandler(KeyEvent e){
//
//    }
}
