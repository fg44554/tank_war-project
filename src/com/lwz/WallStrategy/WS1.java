package com.lwz.WallStrategy;

import com.lwz.tank_master.GameObjects;
import com.lwz.tank_master.Tank_model;
import com.lwz.tank_master.Wall;
import org.w3c.dom.css.Rect;

import static com.lwz.tank_master.Tank_model.*;

public class WS1  {
    public static void addWall() {
        getInstance().gameObjects.add(new Wall(0,420,100,100));
        getInstance().gameObjects.add(new Wall(100,120,100,300));
        getInstance().gameObjects.add(new Wall(200,120,100,100));
        getInstance().gameObjects.add(new Wall(200,320,100,100));
        getInstance().gameObjects.add(new Wall(400,220,100,300));
        getInstance().gameObjects.add(new Wall(500,120,100,100));
        getInstance().gameObjects.add(new Wall(600,220,100,100));
        getInstance().gameObjects.add(new Wall(600,420,100,100));
        getInstance().gameObjects.add(new Wall(700,520,100,200));
        getInstance().gameObjects.add(new Wall(200,620,400,100));
        getInstance().gameObjects.add(new Wall(100,720,100,100));
        getInstance().gameObjects.add(new Wall(800,520,100,100));
        getInstance().gameObjects.add(new Wall(800,120,200,100));
    }
}
