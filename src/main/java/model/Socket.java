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
        this.pluggedIn = device;
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
        if(pluggedIn == null){
            return 0;
        }else{
            return pluggedIn.getPower() + wastePower;
        }
    }

}
