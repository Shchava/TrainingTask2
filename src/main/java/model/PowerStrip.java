package model;

import java.util.ArrayList;
import java.util.List;

public class PowerStrip {
    private List<Socket> sockets;
    private final int numberOfSockets;

    public PowerStrip(int numberOfSockets){
        sockets = new ArrayList<>(numberOfSockets);
        this.numberOfSockets = numberOfSockets;
        for(int i =0; i < numberOfSockets;i++){
            sockets.add(new Socket());
        }
    }

    public List<Socket> getConnectedParts() {
        return sockets;
    }

    public int getUsedPower(){
        int power = 0;
        for(ConnectAbleNetworkPart p:sockets){
            power += p.getUsedPower();
        }
        return power;
    }

    public int getNumberOfSockets() {
        return numberOfSockets;
    }

    public void plugIn(ConnectAbleNetworkPart device){
        for(Socket p:sockets){
            if(p.getPluggedInDevice() == null){
                p.plugIn(device);
                return;
            }
        }
        throw new IllegalStateException("no root to insert new device");
    }
}
