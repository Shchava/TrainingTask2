package model;

import java.util.ArrayList;
import java.util.List;

public class PowerStrip {
    private List<ConnectAbleNetworkPart> sockets;
    private final int numberOfSockets;

    public PowerStrip(int numberOfSockets){
        sockets = new ArrayList<>(numberOfSockets);
        this.numberOfSockets = numberOfSockets;
        for(int i =0; i < numberOfSockets;i++){
            sockets.add(new Socket());
        }
    }

    public List<ConnectAbleNetworkPart> getConnectedParts() {
        return sockets;
    }


}
