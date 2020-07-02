package com.lwz.tank_master;

import java.awt.*;
import java.awt.event.*;

public class TankRun extends Frame {
    //游戏窗口的高宽，固定值
    public static final Integer GAME_WIDTH = 1000, GAME_HEIGHT = 1000;
    //一个tank的实例
//    Etank etank = new Etank(200, 200,  TankProp.DOWN,this);
//    List<TankClass> tankClasses=new ArrayList<>();
    //子弹的容器
//    Tank_model Tank_model.getInstance() = new Tank_model();

    //    Bullet b=new Bullet(10,10,TankProp.DOWN);
    //本类的构造器，运行时自动加载
    public TankRun() throws HeadlessException {
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setTitle("TankWar");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new Key());
    }

    //双缓冲预加载
    Image offScreenImage = null;

    public void update(Graphics g) {
        if (offScreenImage == null) {
            //这是游戏窗口的宽度和高度
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOff = offScreenImage.getGraphics();
        Color c = gOff.getColor();
        gOff.setColor(Color.BLACK);
        gOff.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOff.setColor(c);
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public void paint(Graphics g) {
        Tank_model.getInstance().paint(g);

    }

    //重写的键盘适配内部类
    class Key extends KeyAdapter {
        boolean bu = false;
        boolean bd = false;
        boolean bl = false;
        boolean br = false;

        //键盘绑定，按下
        @Override
        public void keyPressed(KeyEvent e) {
            int i = e.getKeyCode();
            switch (i) {
                case KeyEvent.VK_UP:
                    bu = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                default:
                    break;
            }
            tankDir();
        }

        //键盘绑定，释放
        @Override
        public void keyReleased(KeyEvent e) {
            int j = e.getKeyCode();
            switch (j) {
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_A:
                    Tank_model.getInstance().tank.fire(Tank_model.getInstance().tank, new Fire() {
                        @Override
                        public void openfire(Tank tank) {
                            TankClass t = (TankClass) tank;
                            //重复new可以一次发射多个子弹，角度和速度可调节
                            int bx = t.x + TankClass.WIDTH / 2 - Bullet.WIDTH / 2;
                            int by = t.y + TankClass.HEIGHT / 2 - Bullet.HEIGHT / 2;
                            for (int i = 0; i < TankProp.values().length; i++) {
                                Tank_model.getInstance().gameObjects.add(new Bullet(bx, by, TankProp.values()[i], 3, t.getGroup()));
                                Tank_model.bulletCount++;
                            }

                        }
                    });
                    break;
                case KeyEvent.VK_S:
                    Tank_model.getInstance().tank.fire(Tank_model.getInstance().tank, new Fire() {


                        @Override
                        public void openfire(Tank tank) {
                            TankClass t = (TankClass) tank;
                            //重复new可以一次发射多个子弹，角度和速度可调节
                            int bx = t.x + TankClass.WIDTH / 2 - Bullet.WIDTH / 2;
                            int by = t.y + TankClass.HEIGHT / 2 - Bullet.HEIGHT / 2;
                            for (int i = 0; i < 1; i++) {
                                Tank_model.getInstance().gameObjects.add(new Bullet(bx, by, t.getDir(), 2, t.getGroup()));
                                Tank_model.getInstance().gameObjects.add(new Bullet(bx, by, t.getDir(), 3, t.getGroup()));
                                Tank_model.getInstance().gameObjects.add(new Bullet(bx, by, t.getDir(), 4, t.getGroup()));
                                Tank_model.bulletCount++;
                            }

                        }
                    });
                    break;
                case KeyEvent.VK_D:
                    Tank_model.getInstance().tank.fire(Tank_model.getInstance().tank, new Fire() {


                        @Override
                        public void openfire(Tank tank) {
                            TankClass t = (TankClass) tank;
                            //重复new可以一次发射多个子弹，角度和速度可调节
                            int bx = t.x + TankClass.WIDTH / 2 - Bullet.WIDTH / 2;
                            int by = t.y + TankClass.HEIGHT / 2 - Bullet.HEIGHT / 2;
                            if (t.getDir() == TankProp.UP || t.getDir() == TankProp.LEFT || t.getDir() == TankProp.DOWN || t.getDir() == TankProp.RIGHT) {
                                for (int i = 0; i < 1; i++) {
                                    Tank_model.getInstance().gameObjects.add(new Bullet(bx, by, t.getDir(), 8, t.getGroup()));
                                    Tank_model.getInstance().gameObjects.add(new Bullet(bx + 40, by - 40, t.getDir(), 8, t.getGroup()));
                                    Tank_model.getInstance().gameObjects.add(new Bullet(bx - 40, by + 40, t.getDir(), 8, t.getGroup()));
                                    Tank_model.bulletCount += 3;
                                }
                            } else {
                                Tank_model.getInstance().gameObjects.add(new Bullet(bx, by, t.getDir(), 8, t.getGroup()));
                            }
                        }
                    });
                    break;
                case KeyEvent.VK_Q:
                    //执行多个fire方法可增加一次发射的个数==增加了子弹威力
                    for (int i = 0; i < 1; i++) {
                        Tank_model.getInstance().tank.fire(Tank_model.getInstance().tank, new Fire() {
                            @Override
                            public void openfire(Tank tank) {
                                TankClass t = (TankClass) tank;
                                //重复new可以一次发射多个子弹，角度和速度可调节
                                int bx = t.x + TankClass.WIDTH / 2 - Bullet.WIDTH / 2;
                                int by = t.y + TankClass.HEIGHT / 2 - Bullet.HEIGHT / 2;
                                Tank_model.getInstance().gameObjects.add(new Bullet(bx, by, TankProp.LEFT, 2, t.getGroup()));
                                Tank_model.getInstance().gameObjects.add(new Bullet(bx, by, TankProp.DOWN, 2, t.getGroup()));
                                Tank_model.getInstance().gameObjects.add(new Bullet(bx, by, TankProp.RIGHT, 2, t.getGroup()));
                                Tank_model.getInstance().gameObjects.add(new Bullet(bx, by, TankProp.UP, 2, t.getGroup()));
                                Tank_model.bulletCount += 4;
                            }
                        });
                    }
                    break;
                case KeyEvent.VK_W:

                    for (int i = 0; i < 10; i++) {
                        Tank_model.getInstance().getTank().fireHandle();
                    }
                    break;
                case KeyEvent.VK_E:
                    Tank_model.getInstance().addTank();

                    break;
                case KeyEvent.VK_CONTROL:
                    Tank_model.getInstance();
                    break;
                default:
                    break;
            }
            tankDir();
        }

        //tank方向与案件绑定
        public void tankDir() {
            if (!bl && !bd && !br && !bu) {
                Tank_model.getInstance().tank.setMoving(false);
            } else {
                Tank_model.getInstance().tank.setMoving(true);
                if (bu) {
                    Tank_model.getInstance().tank.setDir(TankProp.UP);
                }
                if (bd) {
                    Tank_model.getInstance().tank.setDir(TankProp.DOWN);
                }
                if (bl) {
                    Tank_model.getInstance().tank.setDir(TankProp.LEFT);
                }
                if (br) {
                    Tank_model.getInstance().tank.setDir(TankProp.RIGHT);
                }
                if (bu & br) {
                    Tank_model.getInstance().tank.setDir(TankProp.UR);
                }
                if (bu & bl) {
                    Tank_model.getInstance().tank.setDir(TankProp.UL);
                }
                if (bd & br) {
                    Tank_model.getInstance().tank.setDir(TankProp.DR);
                }
                if (bd & bl) {
                    Tank_model.getInstance().tank.setDir(TankProp.DL);
                }
            }
        }
    }

}