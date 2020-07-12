package com.lwz.tank_master;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

//这个类是把图片与加载到内存，其他类直接调用
public class ResourceMgr {
    public static BufferedImage goodtankL, goodtankU, goodtankR, goodtankD, goodtankLD, goodtankLU, goodtankRD, goodtankRU,
            badtankL, badtankU, badtankR, badtankD, badtankLD, badtankLU, badtankRD, badtankRU,
            bulletU, bulletD, bulletL, bulletR, missileLD, missileLU, missileRD, missileRU, BOMBU;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            goodtankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodtankL = ImageUtil.rotateImage(goodtankU, -90);
            goodtankR = ImageUtil.rotateImage(goodtankU, 90);
            goodtankD = ImageUtil.rotateImage(goodtankU, 180);
            goodtankRD = ImageUtil.rotateImage(goodtankU, 135);
            goodtankLD = ImageUtil.rotateImage(goodtankU, -135);
            goodtankRU = ImageUtil.rotateImage(goodtankU, 45);
            goodtankLU = ImageUtil.rotateImage(goodtankU, -45);
            badtankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badtankL = ImageUtil.rotateImage(badtankU, -90);
            badtankR = ImageUtil.rotateImage(badtankU, 90);
            badtankD = ImageUtil.rotateImage(badtankU, 180);
            badtankRD = ImageUtil.rotateImage(badtankU, 135);
            badtankLD = ImageUtil.rotateImage(badtankU, -135);
            badtankRU = ImageUtil.rotateImage(badtankU, 45);
            badtankLU = ImageUtil.rotateImage(badtankU, -45);
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            missileLD = ImageUtil.rotateImage(bulletU, -135);
            missileRU = ImageUtil.rotateImage(bulletU, 45);
            missileLU = ImageUtil.rotateImage(bulletU, -45);
            missileRD = ImageUtil.rotateImage(bulletU, 135);
            BOMBU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/3.gif"));
            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
