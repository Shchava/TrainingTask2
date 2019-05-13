package model;

import java.util.ArrayList;
import java.util.List;

public class PowerLine {
    private List<ConnectAbleNetworkPart> connected;

    public PowerLine(){
        connected = new ArrayList<>();
    }

    public void plugIn(ConnectAbleNetworkPart device){
        connected.add(device);
    }

    public List<ConnectAbleNetworkPart> getConnectedParts(){
        return connected;
    }
}
