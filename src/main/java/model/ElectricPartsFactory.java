package model;

public interface ElectricPartsFactory {
    Socket createSocket();
    Socket createSocket(int wastePower);

    PowerStrip createPowerStrip(int numberOfSockets);
    PowerStrip createPowerStrip(int numberOfSockets, int wastePower);

    PowerLine createPowerLine();

    ElectricityConsumer createElectricityConsumer(String name, int power);
}
