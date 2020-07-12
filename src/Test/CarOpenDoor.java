package Test;

public class CarOpenDoor implements CarStates {
    @Override
    public void openDoor() {
        System.out.println("车门已经打开了");
    }

    @Override
    public void closeDoor() {
        System.out.println("车门关闭");
    }

    @Override
    public void run() {
        System.out.println("危险!车门未关闭");
    }

    @Override
    public void stop() {
        System.out.println("车已经是停滞状态了");
    }
}
