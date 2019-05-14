package view;

import model.ConnectAbleNetworkPart;

import java.util.ResourceBundle;

public class View {
    public static final String MESSAGES_BUNDLE_NAME = "Messages";
    public static final String DEVICES_NAMES_BUNDLE_NAME = "Devices";

    public static int OFFSET_WIDTH = 3;

    public ResourceBundle messages = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME);
    public ResourceBundle devicesNames = ResourceBundle.getBundle(DEVICES_NAMES_BUNDLE_NAME);

    public void print(String message){
        System.out.println(message);
    }

    public void printContinueInvitation(){
        String message = String.format(messages.getString("continueInvitation"),messages.getString("continue"));
        print(message);
    }

    public void printTotalPower(int totalPower){
        String message = String.format(messages.getString("printTotalPower"),totalPower);
        print(message);
    }

    public void printPart(ConnectAbleNetworkPart part,int power, int offset){
        String message = String.format(messages.getString("printPart"),createOffset(offset),devicesNames.getString(part.toString()),power);
        print(message);
    }

    public void printElectricityConsumer(String name, int power, boolean isTurnedOn,int offset){
        String turned = isTurnedOn ? messages.getString("turnedOn") : messages.getString("turnedOff");
        String message = String.format(messages.getString("printConsumer"),createOffset(offset),devicesNames.getString(name),turned,power);
        print(message);
    }

    private String createOffset(int offset){
        return new String(new char[OFFSET_WIDTH * offset]).replace('\0', ' ');
    }
}
