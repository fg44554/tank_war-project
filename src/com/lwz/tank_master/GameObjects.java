package com.lwz.tank_master;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameObjects implements Serializable {
   public List<GameObjects> gameObjects = new ArrayList<>();
    int x, y;


    public void paint(Graphics g) {

    }


    void collideWith(GameObjects gameObjects, GameObjects gameObjects1, Collider collider) {
        collider.collide(gameObjects, gameObjects1);
    }
}
