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
    public void testIncrementSpeed(){
        saab.incrementSpeed(10);
        assert(saab.getCurrentSpeed() == 12.6);
        saab.incrementSpeed(100);
        assert(saab.getCurrentSpeed() == 137.6);

    }

    @Test
    public void testDecrementSpeed(){
        saab.decrementSpeed(0.01);
        System.out.println(saab.getCurrentSpeed());
        assert(saab.getCurrentSpeed() == 0.08750000000000001);
        saab.decrementSpeed(10);
        System.out.println(saab.getCurrentSpeed());
        assert(saab.currentSpeed == -12.4125);
    }

    @Test
    public void testGas(){
        saab.gas(0.5);
        assert(saab.getCurrentSpeed() == 0.725);
    }

    @Test
    public void testBrake(){
        saab.brake(0.05);
        System.out.println(saab.getCurrentSpeed());
        assert(saab.getCurrentSpeed() == 0.037500000000000006);
    }

}
