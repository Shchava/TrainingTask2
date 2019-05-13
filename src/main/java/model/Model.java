package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    List<PowerLine> lines;

    public Model(){
        lines = new ArrayList<>();
    }

    public void DefaultInitialization(){
        lines.addAll(DefaultValues.Default.lines);
    }

    public int getTotalPower(){
        return lines.stream().mapToInt(PowerLine::getUsedPower).sum();
    }
}
