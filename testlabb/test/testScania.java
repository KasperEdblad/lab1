import org.junit.Before;
import org.junit.Test;


public class testScania {

    private Scania scania;

    @Before
    public void init(){
        scania = new Scania();
        scania.startEngine();
    }

    @Test
    public void testIncreaseFlatBedAngel(){
        scania.stopEngine();
        scania.raiseFlatbed();
        assert(scania.getFlatbedAngle() == 1);
    }

    @Test
    public void testPosAfterFlatbed(){
        scania.stopEngine();
        scania.raiseFlatbed();
        scania.startEngine();
        scania.move();
        assert(scania.getPosX() == 0);
    }
}
