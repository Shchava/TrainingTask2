package model;

public class Socket{
    private Object pluggedIn;
    private int wastePower;

    public Socket() {

    }
    public Socket(int wastePower){
        this.wastePower = wastePower;
    }


    public void plugIn(ElectricityConsumer device){
        if(this.pluggedIn == null){
            this.pluggedIn = device;
        }else{
            throw new IllegalStateException("Socket already has plugged device" + device);
        }
    }

    public ElectricityConsumer getPluggedInConsumer() {
        return (ElectricityConsumer) pluggedIn;
    }

    public void plugOut(){
        pluggedIn = null;
    }

    public int getUsedPower(){
        if(pluggedIn == null || ((ElectricityConsumer)pluggedIn).getPower() == 0){
            return 0;
        }else{
            return ((ElectricityConsumer)pluggedIn).getPower() + wastePower;
        }
    }
}
