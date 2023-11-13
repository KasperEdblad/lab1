import org.junit.Before;
import org.junit.Test;


public class testVolvo {
    private Volvo240 volvo;


    @Before
    public void init(){
        volvo = new Volvo240();
        volvo.startEngine();
    }

    @Test
    public void testSpeedFactor(){
        assert(volvo.speedFactor() == 1.25);
    }

    @Test
    public void testIncrementSpeed(){
        volvo.incrementSpeed(10);
        assert(volvo.currentSpeed == 12.6);
        volvo.incrementSpeed(100);
        assert(volvo.currentSpeed == 100);

    }

    @Test
    public void testDecrementSpeed(){
        volvo.decrementSpeed(10);
        assert(volvo.currentSpeed == 0);
        volvo.decrementSpeed(-10);
        assert(volvo.currentSpeed == 12.5);
    }

    @Test
    public void testGas(){
        volvo.gas(0.5);
        assert(volvo.getCurrentSpeed() == 0.725);
    }

    @Test
    public void testBrake(){
        volvo.brake(0.05);
        System.out.println(volvo.getCurrentSpeed());
        assert(volvo.getCurrentSpeed() == 0.037500000000000006);
    }
}
