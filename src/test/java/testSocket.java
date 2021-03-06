import model.ElectricityConsumer;
import model.Socket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class testSocket {
    Socket testSocket;
    ElectricityConsumer testConsumer;

    @BeforeEach
    void init(){
        testConsumer = new ElectricityConsumer("Test",25);
        testConsumer.setTurnedOn(true);
        testSocket = new Socket();
    }

    @Test
    void testConnect(){
        testSocket.plugIn(testConsumer);
        assertEquals(25,testSocket.getUsedPower());
    }

    @Test()
    void testMultipleConnect(){
        testSocket.plugIn(testConsumer);
        ElectricityConsumer newConsumer = new ElectricityConsumer("test2",3);
        assertThrows(IllegalStateException.class, () -> {
            testSocket.plugIn(newConsumer);
        });


    }

    @Test
    void testPlugOut(){
        testSocket.plugIn(testConsumer);
        ElectricityConsumer pulled = (ElectricityConsumer) testSocket.getPluggedInDevice();
        testSocket.plugOut();

        assertEquals(pulled, testConsumer);
        ElectricityConsumer newConsumer = new ElectricityConsumer("test2",3);
        newConsumer.setTurnedOn(true);
        testSocket.plugOut();
        testSocket.plugIn(newConsumer);
        assertEquals(3,testSocket.getUsedPower());
    }

    @Test
    void testWastePower(){
        Socket wasteSocket = new Socket(10);
        wasteSocket.plugIn(testConsumer);
        assertEquals(35,wasteSocket.getUsedPower());

        testConsumer.setTurnedOn(false);
        assertEquals(0,wasteSocket.getUsedPower());
    }

    @Test
    void testConnectNetworkPart(){
        Socket anotherSocket = new Socket(3);
        anotherSocket.plugIn(testConsumer);
        testSocket.plugIn(anotherSocket);

        assertEquals(25+3,testSocket.getUsedPower());
    }

    @Test
    void getConnectedParts(){
        Socket anotherSocket = new Socket(3);
        anotherSocket.plugIn(testConsumer);
        testSocket.plugIn(anotherSocket);

        assertEquals(anotherSocket,testSocket.getConnectedParts().get(0));
        assertEquals(0,anotherSocket.getConnectedParts().size());
    }
}
