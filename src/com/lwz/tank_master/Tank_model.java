package com.lwz.tank_master;

import com.lwz.WallStrategy.WS1;
import com.lwz.WallStrategy.WallMod;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tank_model extends GameObjects {
    TankClass tank = new TankClass(600, 600, Integer.parseInt((String) PropMgr.get("speed")), TankProp.DOWN,  Group.GOOD);
    Wall wall=null;
        int bo;
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
        this.gameObjects.add(tank);
        //初始化敌方坦克
        for (int i = 0; i < Integer.parseInt((String) PropMgr.get("initTankCount")); i++) {
            this.gameObjects.add(new TankClass(150 + i * 80, 950, 1, TankProp.UP,  Group.BAD));
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
        g.drawString("生命" + tank.getBlood(), 100, 120);
        g.drawString("第" + (bo+1)+"波", 100, 140);
        if(tankCount==0){
            for ( bo = 0; bo <(int)100/tank.getBlood()+(int) tank.getBlood()/10; bo++) {
                Tank_model.getInstance().addTank();
            }}
//        collide(gameObjects);
        if(tank.getBlood()==0){
        g.drawString("你死了,存活了"+bo+"波" , 500, 500);}
        if (gameObjects.size() == 0) {
            g.drawString("你胜利了", 500, 500);
        }
        g.setColor(c);
//        if(tank.getBlood()>0){tank.paint(g);}else{return;}

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
        this.gameObjects.add(new TankClass(random.nextInt(800), 950, 1, TankProp.UP, Group.BAD));
        tankCount++;
    }
    public TankClass getTank(){return tank;}
//    public void collide(List<GameObjects> gameObjects){
//        for (int i = 0; i <this.gameObjects.size() ; i++) {
//            if(gameObjects.get(i) instanceof Bullet){
//                Bullet bullet = (Bullet) gameObjects.get(i);
//                if(this.tank.getRect().intersects(bullet.rect)){
//                    this.tank.setBlood();
//                }
//            }return;
//
//
//        }
//
//
//
//    }
}
