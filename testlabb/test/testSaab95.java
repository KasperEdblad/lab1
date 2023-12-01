import org.junit.Before;
import org.junit.Test;


public class testSaab95{
    private Saab95 saab;


    @Before
    public void init(){
        saab = new Saab95();
        saab.startEngine();
    }

    @Test
    public void testSetTurboOn(){
        saab.setTurboOn();
        assert(saab.turboOn);
    }

    @Test
    public void testSetTurboOff(){
        saab.setTurboOff();
        assert(!saab.turboOn);
    }

    @Test
    public void testSpeedFactor(){
        assert(saab.speedFactor() == 1.25);
        saab.setTurboOn();
        assert(saab.speedFactor() == 1.625);

    }

    @Test
    public void testGas(){
        saab.gas(0.5);
        assert(saab.getCurrentSpeed() == 0.725);
    }

    @Test
    public void testBrake(){
        saab.brake(0.05);
        assert(saab.getCurrentSpeed() == 0.037500000000000006);
    }

}
