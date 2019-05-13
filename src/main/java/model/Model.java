package model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    List<PowerLine> powerLines;

    public Model(){
        powerLines = new ArrayList<>();
    }

    public void DefaultInitialization(){
        powerLines.addAll(DefaultValues.Default.lines);
    }

    public int getTotalPower(){
        return powerLines.stream().mapToInt(PowerLine::getUsedPower).sum();
    }

    public List<PowerLine> getPowerLines() {
        return powerLines;
    }
}
