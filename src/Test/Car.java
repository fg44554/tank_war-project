package Test;

public class Car {
    CarStates cs=new CarCloseDoor();

    public void openDoor() {
        cs.openDoor();
    }

    public void closeDoor() {
        cs.closeDoor();
    }

    public void run() {
        cs.run();
    }

    public void stop() {
        cs.stop();
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.openDoor();
    }
}
