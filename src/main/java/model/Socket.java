package model;

public class Socket{
    private ElectricityConsumer pluggedIn;
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

    public ElectricityConsumer getPluggedIn() {
        return pluggedIn;
    }

    public  ElectricityConsumer plugOut(){
        ElectricityConsumer res = pluggedIn;
        pluggedIn = null;
        return  res;
    }

    public int getUsedPower(){
        if(pluggedIn == null || pluggedIn.getPower() == 0){
            return 0;
        }else{
            return pluggedIn.getPower() + wastePower;
        }
    }

}
