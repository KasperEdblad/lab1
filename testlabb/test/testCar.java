import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class testCar {
    private Saab95 saab;

    @Before
    public void init(){
        saab = new Saab95();
        saab.startEngine();
    }

    @Test
    public void testGetPosX(){
        assert(saab.getPosX() == 100);
    }

    @Test
    public void testGetPosY(){
        assert(saab.getPosY() == 100);
    }

    @Test
    public void testGetDirection(){
        assert(saab.getDirection() == 0);
    }

    @Test
    public void testGetNrDoors(){
        assert(saab.getNrDoors() == 2);
    }

    @Test
    public void testGetEnginePower(){
        assert(saab.getEnginePower() == 125);
    }

    @Test
    public void testGetCurrentSpeed(){
        assert(saab.getCurrentSpeed() == saab.currentSpeed);
    }

    @Test
    public void testGetColors(){
        assert(saab.getColor() == Color.red);
    }

    @Test
    public void testSetColor(){
        saab.setColor(Color.green);
        assert(saab.getColor() == Color.green);
    }

    @Test
    public void testStartEngine(){
        assert(saab.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testStopEngine(){
        saab.stopEngine();
        assert(saab.getCurrentSpeed() == 0);
    }


    @Test
    public void testMove(){
        saab.move();
        assert(saab.getPosX() == 100.1);
    }

    @Test
    public void testTurn(){
        saab.turnLeft();
        assert(saab.getDirection() == 3);
        saab.turnRight();
        assert(saab.getDirection() == 0);
        saab.turnRight();
        assert(saab.getDirection() == 1);
        saab.turnLeft();
        assert(saab.getDirection() == 0);
    }

    @Test
    public void testTurnAndMove(){
        saab.turnRight();
        saab.move();
        assert(saab.getPosY() == 100.1);
    }
}
