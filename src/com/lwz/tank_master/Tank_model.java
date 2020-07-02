package com.lwz.tank_master;

import com.lwz.WallStrategy.WS1;
import com.lwz.WallStrategy.WallMod;

import java.awt.*;
import java.util.Random;

public class Tank_model extends GameObjects {
    TankClass tank = new TankClass(600, 600, Integer.parseInt((String) PropMgr.get("speed")), TankProp.DOWN, this, Group.GOOD);
    Wall wall=null;

    static int tankCount = 0;
    static int bulletCount = 0;
    static int bombCount = 0;
    ColloderChain chain;


    {
        try {
            chain = new ColloderChain();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static final Tank_model INSTANCE = new Tank_model();

    static {
        INSTANCE.init();
    }


    public static Tank_model getInstance() {
        return INSTANCE;

    }

    private void init() {
        //初始化敌方坦克
        for (int i = 0; i < Integer.parseInt((String) PropMgr.get("initTankCount")); i++) {
            this.gameObjects.add(new TankClass(350 + i * 80, 200, 1, TankProp.DOWN, this, Group.BAD));
            tankCount++;
        }
//        //初始化墙
//         new WS1().addWall();
            WS1.addWall();
        System.out.println(new Wall(200,200,20,20).rect.x);

    }

    private Tank_model() {

    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GREEN);
        g.drawString("爆炸数量" + bombCount, 100, 60);
        g.drawString("子弹数量" + bulletCount, 100, 80);
        g.drawString("坦克数量" + tankCount, 100, 100);
        if (gameObjects.size() == 0) {
            g.drawString("你胜利了", 500, 500);
        }
        g.setColor(c);
        tank.paint(g);
        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = i + 1; j < gameObjects.size(); j++) {
//                gameObjects.get(i).collideWith(gameObjects.get(j), gameObjects.get(i), new BulletTankCollider());
                chain.collider(gameObjects.get(j), gameObjects.get(i));
            }
        }


    }


    public void addTank() {
        Random random = new Random();
        this.gameObjects.add(new TankClass(random.nextInt(800), random.nextInt(800), 1, TankProp.DOWN, this, Group.BAD));
        tankCount++;
    }

}
