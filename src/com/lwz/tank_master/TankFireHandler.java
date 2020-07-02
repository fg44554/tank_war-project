package com.lwz.tank_master;

public class TankFireHandler implements FireOberver {

    @Override
    public void tankFireHandle(Event e) {
        TankClass source = e.getSource();
        source.fire(Tank_model.getInstance().tank, new Fire() {
            @Override
            public void openfire(Tank tank) {
                TankClass t = (TankClass) tank;
                int bx = t.x + TankClass.WIDTH / 2 - BOMB.WIDTH / 2;
                int by = t.y + TankClass.HEIGHT / 2 - BOMB.HEIGHT / 2;
                if (t.getDir() == TankProp.LEFT) {
                    Tank_model.getInstance().gameObjects.add(new Explode(t.x - 45, t.y));
                } else if (t.getDir() == TankProp.RIGHT) {
                    Tank_model.getInstance().gameObjects.add(new Explode(t.x + 45, t.y));

                } else if (t.getDir() == TankProp.DOWN) {
                    Tank_model.getInstance().gameObjects.add(new Explode(t.x, t.y + 45));
                } else if (t.getDir() == TankProp.UP) {
                    Tank_model.getInstance().gameObjects.add(new Explode(t.x, t.y - 45));
                }
                if (t.getDir() == TankProp.UR) {
                    Tank_model.getInstance().gameObjects.add(new Explode(t.x + 45, t.y - 45));

                } else if (t.getDir() == TankProp.UL) {
                    Tank_model.getInstance().gameObjects.add(new Explode(t.x - 45, t.y - 45));

                } else if (t.getDir() == TankProp.DR) {
                    Tank_model.getInstance().gameObjects.add(new Explode(t.x + 45, t.y + 45));

                } else if (t.getDir() == TankProp.DL) {
                    Tank_model.getInstance().gameObjects.add(new Explode(t.x - 45, t.y + 45));

                }
                if (t.getDir() == TankProp.LEFT) {
                    Tank_model.getInstance().gameObjects.add(new BOMB(bx - 45, by, t.getDir(), 5));
                    Tank_model.bombCount++;
                } else if (t.getDir() == TankProp.RIGHT) {
                    Tank_model.getInstance().gameObjects.add(new BOMB(bx + 45, by, t.getDir(), 5));
                    Tank_model.bombCount++;
                } else if (t.getDir() == TankProp.DOWN) {
                    Tank_model.getInstance().gameObjects.add(new BOMB(bx, by + 45, t.getDir(), 5));
                    Tank_model.bombCount++;
                } else if (t.getDir() == TankProp.UP) {
                    Tank_model.getInstance().gameObjects.add(new BOMB(bx, by - 45, t.getDir(), 5));
                    Tank_model.bombCount++;
                }
                if (t.getDir() == TankProp.UR) {
                    Tank_model.getInstance().gameObjects.add(new BOMB(bx + 45, by - 45, t.getDir(), 5));
                    Tank_model.bombCount++;
                } else if (t.getDir() == TankProp.UL) {
                    Tank_model.getInstance().gameObjects.add(new BOMB(bx - 45, by - 45, t.getDir(), 5));
                    Tank_model.bombCount++;
                } else if (t.getDir() == TankProp.DR) {
                    Tank_model.getInstance().gameObjects.add(new BOMB(bx + 45, by + 45, t.getDir(), 5));
                    Tank_model.bombCount++;
                } else if (t.getDir() == TankProp.DL) {
                    Tank_model.getInstance().gameObjects.add(new BOMB(bx - 45, by + 45, t.getDir(), 5));
                    Tank_model.bombCount++;
                }
            }

        });
    }
}
