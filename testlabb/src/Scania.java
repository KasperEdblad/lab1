import java.awt.*;

public class Scania extends Car{

    private final static double trimFactor = 1.25;
    private static int bedAngel = 0;

    public Scania(){
        super(200,200,0, 2, 500, Color.blue,"Scania" );
    }

    public void startEngine(){
        assert(bedAngel == 0);
        currentSpeed = 0.1;
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void gas(double amount){
        assert(amount > 0 && amount < 1 );
        double speedBeforeGas = getCurrentSpeed();
        incrementSpeed(amount);
        assert(speedBeforeGas < getCurrentSpeed());
    }

    public void brake(double amount){
        assert(amount > 0 && amount < 1 );
        double speedBeforeBrake = getCurrentSpeed();
        decrementSpeed(amount);
        assert(speedBeforeBrake > getCurrentSpeed());
    }

    public int getBedAngel(){
        return bedAngel;
    }

    public void increaseBedAngel(){
        assert(currentSpeed == 0);
        bedAngel += 1;
    }

    public void decreaseBedAngel(){
        assert(currentSpeed == 0);
        bedAngel -= 1;
    }
}
