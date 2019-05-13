import model.ConnectAbleNetworkPart;
import model.ElectricityConsumer;
import model.PowerStrip;
import model.Socket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testPowerStrip {
    PowerStrip testStrip;
    ElectricityConsumer ec1;
    ElectricityConsumer ec2;
    ElectricityConsumer ec3;

    @BeforeEach
    void init(){
        testStrip = new PowerStrip(5);
        ec1 = new ElectricityConsumer("test1",10);
        ec1.setTurnedOn(true);
        ec2 = new ElectricityConsumer("test2",20);
        ec2.setTurnedOn(true);
        ec3 = new ElectricityConsumer("test3",30);
        ec3.setTurnedOn(true);
    }

    @Test
    void testGetConnectedParts(){
        List<ConnectAbleNetworkPart> parts =  testStrip.getConnectedParts();
        assertEquals(5,parts.size());
    }

    @Test
    void testGetUsedPower(){
        List<ConnectAbleNetworkPart> parts =  testStrip.getConnectedParts();
        ((Socket)parts.get(0)).plugIn(ec1);
        ((Socket)parts.get(1)).plugIn(ec2);
        ((Socket)parts.get(3)).plugIn(ec3);

        assertEquals(60,testStrip.getUsedPower());
    }
}
