package com.lwz.WallStrategy;

import com.lwz.tank_master.GameObjects;
import com.lwz.tank_master.Tank_model;
import com.lwz.tank_master.Wall;
import org.w3c.dom.css.Rect;

import static com.lwz.tank_master.Tank_model.*;

public class WS1  {
    public static void addWall() {
        getInstance().gameObjects.add(new Wall(200,200,20,80));
        getInstance().gameObjects.add(new Wall(600,400,40,20));
        getInstance().gameObjects.add(new Wall(400,240,20,160));
        getInstance().gameObjects.add(new Wall(440,660,20,80));
        getInstance().gameObjects.add(new Wall(80,880,20,80));
        getInstance().gameObjects.add(new Wall(200,220,20,40));
    }
}
