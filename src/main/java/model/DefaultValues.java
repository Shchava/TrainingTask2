package model;

import java.util.ArrayList;
import java.util.List;

public enum DefaultValues {
    Default;
    ElectricPartsFactory factory = ElectricPartsFactory.getInstance();
    List<PowerLine> lines;
    DefaultValues(){
        lines = new ArrayList<>(2);
        PowerLine powerLine1 = factory.createPowerLine();

        Socket sc1 = factory.createSocket();
        ElectricityConsumer fridge1 = factory.createElectricityConsumer("fridge",500);
        fridge1.setTurnedOn(true);
        sc1.plugIn(fridge1);
        powerLine1.plugIn(sc1);

        Socket sc2 = factory.createSocket();
        ElectricityConsumer lamp1 = factory.createElectricityConsumer("lamp",50);
        sc2.plugIn(lamp1);
        powerLine1.plugIn(sc2);

        PowerStrip ps1 = factory.createPowerStrip(3,10);
        ElectricityConsumer radio1 = factory.createElectricityConsumer("radio",20);
        ElectricityConsumer laptop1 = factory.createElectricityConsumer("laptop",70);
        laptop1.setTurnedOn(true);
        ps1.plugIn(radio1);
        ps1.plugIn(laptop1);
        powerLine1.plugIn(ps1);

        lines.add(powerLine1);
    }
}
