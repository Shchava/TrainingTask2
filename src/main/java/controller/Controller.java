package controller;

import model.Model;
import view.View;

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

    }
}
