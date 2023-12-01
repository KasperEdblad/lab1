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
    public void testGas(){
        volvo.gas(0.5);
        System.out.println(volvo.getCurrentSpeed());
        assert(volvo.getCurrentSpeed() == 0.725);
        //assert(volvo.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testBrake(){
        volvo.brake(0.05);
        System.out.println(volvo.getCurrentSpeed());
        //assert(volvo.getCurrentSpeed() == 0.037500000000000006);
    }
}
