package com.lwz.tank_master;

import java.util.Properties;

public class PropMgr {
    static Properties prop = new Properties();

    static {
        try {
            prop.load(PropMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (prop == null) return null;
        return prop.get(key);
    }

}
