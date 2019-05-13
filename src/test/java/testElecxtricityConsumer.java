import model.ElectricPartsFactory;
import model.ElectricityConsumer;
import model.StandardElectricPartsFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testElecxtricityConsumer {
    ElectricPartsFactory factory = ElectricPartsFactory.getInstance();
    ElectricityConsumer test;

    @BeforeEach
    void init(){
        test = factory.createElectricityConsumer("Test",20);
    }

    @Test
    void testGetName(){
        assertEquals("Test", test.getName());
    }

    @Test
    void testTurnOn(){
        test.setTurnedOn(true);
        assertEquals(test.getPower(),20);
    }

    @Test
    void testTurnOf(){
        assertEquals(test.getPower(),0);
    }
}
