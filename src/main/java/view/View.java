package view;

import java.util.ResourceBundle;

public class View {
    public static final String MESSAGES_BUNDLE_NAME = "Messages";
    public static final String DEVICES_NAMES_BUNDLE_NAME = "Devices";

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
}
