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
        ElectricityConsumer pulled = testSocket.plugOut();

        assertEquals(pulled, testConsumer);
        ElectricityConsumer newConsumer = new ElectricityConsumer("test2",3);
        newConsumer.setTurnedOn(true);
        testSocket.plugOut();
        testSocket.plugIn(newConsumer);
        assertEquals(3,testSocket.getUsedPower());
    }
}
