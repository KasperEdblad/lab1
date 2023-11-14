import org.junit.Before;
import org.junit.Test;


public class TestScania {

    private Scania scania;

    @Before
    public void init(){
        scania = new Scania();
        scania.startEngine();
    }

    @Test
    public void testIncreaseBedAngel(){
        scania.stopEngine();
        scania.increaseBedAngel();
        assert(scania.getBedAngel() == 1);
    }
}
