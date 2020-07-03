package com.lwz.tank_master;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class ColloderChain implements Collider {
    List<Collider> l = new LinkedList<>();

    public ColloderChain() throws NoSuchMethodException {

        try {
            String colliders1 = (String) PropMgr.get("BTcolliders");
            String colliders2 = (String) PropMgr.get("TTcolliders");
            String colliders3 = (String) PropMgr.get("BWcolliders");
//            String colliders4 = (String) PropMgr.get("TWcolliders");

            l.add((Collider) Class.forName(colliders1).getDeclaredConstructor().newInstance());
//            l.add((Collider) Class.forName(colliders2).getDeclaredConstructor().newInstance());
            l.add((Collider) Class.forName(colliders3).getDeclaredConstructor().newInstance());



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean collide(Object o1, Object o2) {
        return false;
    }

    public void addCollider(Collider collider) {
        l.add(collider);
    }

    public void removeCollider(Collider collider) {
        l.remove(collider);
    }

    public void collider(Object o1, Object o2) {
        for (int i = 0; i < l.size(); i++) {
            boolean collide = l.get(i).collide(o1, o2);
            if (!collide) break;
        }
    }

}
