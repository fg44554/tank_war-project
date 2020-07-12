package Test;

public class CarCloseDoor implements CarStates {
    @Override
    public void openDoor() {
        System.out.println("门开了");
    }

    @Override
    public void closeDoor() {
        System.out.println("车门已经是关闭的");
    }

    @Override
    public void run() {
        System.out.println("车跑起来了");
    }

    @Override
    public void stop() {
        System.out.println("车已经是停滞状态了");
    }
}
