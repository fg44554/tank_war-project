package com.lwz.tank_master;

import java.awt.*;
import java.io.IOException;

public class TestTank extends Frame {


    public static void main(String[] args) throws InterruptedException, IOException {
        TankRun tankRun = new TankRun();
        int i = (Integer.parseInt((String) (PropMgr.get("gameSpeed"))));
        while (true) {
            Thread.sleep(i);
            tankRun.repaint();
        }
    }
}
