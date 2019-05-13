package model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    List<PowerLine> lines;

    public Model(){
        lines = new ArrayList<>();
    }

    public void DefaultInitialization(){
        lines.addAll(DefaultValues.Default.lines);
    }


}
