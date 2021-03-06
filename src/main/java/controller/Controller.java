package controller;

import model.*;
import view.View;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private View view;
    private Model model;
    private Scanner sc;

    public Controller(View view,Model model){
        this.view = view;
        this.model = model;
        sc = new Scanner(System.in);
    }

    public void process(){
        do{
            doMainActions();
            view.printContinueInvitation();
        }while(sc.nextLine().equals(view.messages.getString("continue")));
    }

    private void doMainActions(){
        model.DefaultInitialization();
        view.printTotalPower(model.getTotalPower());
        List<PowerLine> powerLines = model.getPowerLines();
        powerLines.forEach(l->printNetworkParts(l,0));
    };

    private void printNetworkParts(ConnectAbleNetworkPart part,int offset) {
        if (part instanceof Socket) {
            printSocket((Socket)part, offset);
        } else {
            view.printPart(part,part.getUsedPower(), offset);
            List<? extends ConnectAbleNetworkPart> connects = part.getConnectedParts();
                connects.forEach(l->printNetworkParts(l,offset + 1));
        }
    }

    private void printSocket(Socket socket,int offset){
        view.printPart(socket,socket.getUsedPower(), offset);
        Object connected = socket.getPluggedInDevice();
        if(connected != null) {
            if (connected instanceof ConnectAbleNetworkPart) {
                view.printPart((ConnectAbleNetworkPart) connected, ((ConnectAbleNetworkPart) connected).getUsedPower(), offset + 1);
            } else {
                ElectricityConsumer ec = (ElectricityConsumer) connected;
                view.printElectricityConsumer(ec.getName(), ec.getPower(), ec.isTurnedOn(), offset + 1);
            }
        }
    }
}
