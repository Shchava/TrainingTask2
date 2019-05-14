package model;

import java.util.ArrayList;
import java.util.List;

public class PowerLine implements ConnectAbleNetworkPart{
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

    public int getUsedPower(){
        int power = 0;
        for(ConnectAbleNetworkPart c: connected){
            power += c.getUsedPower();
        }
        return power;
    }

    @Override
    public String toString() {
        return "PowerLine";
    }
}
