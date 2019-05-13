import model.PowerLine;
import model.PowerStrip;
import model.Socket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testPowerLine {
    PowerLine testLine;
    PowerStrip strip1;
    Socket socket1;
    Socket socket2;


    @BeforeEach
    void init(){
        testLine = new PowerLine();

    }

    @Test
    void testPlugIn(){
        testLine.plugIn(socket1);
    }

}
