package model;

import java.util.*;

public class Socket implements ConnectAbleNetworkPart{
    private Object pluggedIn;
    private int wastePower;

    public Socket() {

    }
    public Socket(int wastePower){
        this.wastePower = wastePower;
    }


    public void plugIn(ElectricityConsumer device){
        plugIn((Object)device);
    }

    public void plugIn(ConnectAbleNetworkPart device){
        plugIn((Object)device);
    }

    private void plugIn(Object device){
        if(this.pluggedIn == null){
            this.pluggedIn = device;
        }else{
            throw new IllegalStateException("Socket already has plugged device" + pluggedIn);
        }
    }

    public Object getPluggedInDevice() {
        return pluggedIn;
    }

    public void plugOut(){
        pluggedIn = null;
    }

    public int getUsedPower(){
        if(pluggedIn == null || getPowerOfPlugged() == 0){
            return 0;
        }else{
            return getPowerOfPlugged() + wastePower;
        }
    }

    @Override
    public List<ConnectAbleNetworkPart> getConnectedParts() {
        if(pluggedIn instanceof ConnectAbleNetworkPart) {
            return Collections.singletonList((ConnectAbleNetworkPart) pluggedIn);
        }else{
            return Collections.EMPTY_LIST;
        }
    }

    private int getPowerOfPlugged(){
        if(pluggedIn instanceof ElectricityConsumer){
            return ((ElectricityConsumer) pluggedIn).getPower();
        }else{
            return ((ConnectAbleNetworkPart)pluggedIn).getUsedPower();
        }
    }

    @Override
    public String toString() {
        return "Socket";
    }
}
