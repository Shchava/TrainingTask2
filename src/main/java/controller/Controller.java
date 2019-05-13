package controller;

import model.ConnectAbleNetworkPart;
import model.Model;
import model.PowerLine;
import model.Socket;
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
        powerLines.forEach(this::printNetworkParts);
    };

    private void printNetworkParts(ConnectAbleNetworkPart part) {
        if (part instanceof Socket) {
            printSocket((Socket)part);
        } else {
            view.printPart(part,part.getUsedPower());
            List<? extends ConnectAbleNetworkPart> connects = part.getConnectedParts();
            if(connects.size() > 0){
                connects.forEach(this::printNetworkParts);
            }

        }
    }

    private void printSocket(Socket socket){
        view.printPart(socket,socket.getUsedPower());
    }
}
