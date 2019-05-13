import model.ConnectAbleNetworkPart;
import model.PowerStrip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testPowerStrip {
    PowerStrip testStrip;

    @BeforeEach
    void init(){
        testStrip = new PowerStrip(5);
    }

    @Test
    void getConnectedParts(){
        List<ConnectAbleNetworkPart> parts =  testStrip.getConnectedParts();
        assertEquals(5,parts.size());
    }
}
