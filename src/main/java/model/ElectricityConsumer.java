package model;

public class ElectricityConsumer {
    private String name;
    private boolean turnedOn;
    private int power;

    public ElectricityConsumer(String name, int power) {
        this.name = name;
        this.power = power;
        turnedOn = false;
    }

    public String getName() {
        return name;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }

    public int getPower(){
        return turnedOn ? power : 0;
    }
}
