interface Switchable {
    void turnOn();

    void turnOff();
}

class Light implements Switchable {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan is ON");
    }

    public void turnOff() {
        System.out.println("Fan is OFF");
    }
}

public class SwitchableDemo {
    public static void main(String[] args) {
        Switchable light = new Light();
        Switchable fan = new Fan();
        System.out.println("Light Status ");
        light.turnOn();
        light.turnOff();
        System.out.println();
        System.out.println("Fan Status ");
        fan.turnOn();
        fan.turnOff();
    }
}