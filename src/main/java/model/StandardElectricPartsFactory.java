package model;

public class StandardElectricPartsFactory implements ElectricPartsFactory{
    @Override
    public Socket createSocket() {
        return new Socket();
    }

    @Override
    public Socket createSocket(int wastePower) {
        return new Socket(wastePower);
    }

    @Override
    public PowerStrip createPowerStrip(int numberOfSockets) {
        return new PowerStrip(numberOfSockets);
    }

    @Override
    public PowerStrip createPowerStrip(int numberOfSockets, int wastePower) {
        return new PowerStrip(numberOfSockets,wastePower);
    }

    @Override
    public PowerLine createPowerLine() {
        return new PowerLine();
    }

    @Override
    public ElectricityConsumer createElectricityConsumer(String name, int power) {
        return new ElectricityConsumer(name,power);
    }
}
