import model.PowerLine;
import model.PowerStrip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testPowerLine {
    PowerLine testLine;

    @BeforeEach
    void init(){
        testLine = new PowerLine();
    }

}
