import model.ElectricityConsumer;
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
        socket1 = new Socket();
        socket2 = new Socket();
        strip1 = new PowerStrip(2);
    }

    @Test
    void testPlugIn(){
        testLine.plugIn(socket1);
    }

    @Test
    void testGetConnectedParts(){
        testLine.plugIn(socket1);
        testLine.plugIn(strip1);

        assertEquals(2,testLine.getConnectedParts().size());
        assertTrue(testLine.getConnectedParts().contains(socket1));
        assertTrue(testLine.getConnectedParts().contains(strip1));
    }

    @Test
    void testGetUsedPower(){
        ElectricityConsumer ec1 = new ElectricityConsumer("test",20);
        ElectricityConsumer ec2 = new ElectricityConsumer("test2",40);
        ElectricityConsumer ec3 = new ElectricityConsumer("test3",50);

        socket1.plugIn(ec1);
        ec1.setTurnedOn(true);

        strip1.plugIn(ec2);
        strip1.plugIn(ec3);
        ec2.setTurnedOn(true);
        ec3.setTurnedOn(true);

        testLine.plugIn(socket1);
        testLine.plugIn(socket2);
        testLine.plugIn(strip1);

        assertEquals(110,testLine.getUsedPower());
    }

}
