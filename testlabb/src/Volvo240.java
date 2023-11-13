import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(150,150, 0, 4,100, Color.black, "Volvo240");

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


}
