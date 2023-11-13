import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;

    public Saab95(){
        super(100,100, 0, 2,125, Color.red, "Saab95");
        turboOn = false;
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        assert(amount > 0 && amount < 1 );
        double speedBeforeGas = getCurrentSpeed();
        incrementSpeed(amount);
        assert(speedBeforeGas < getCurrentSpeed());
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        assert(amount > 0 && amount < 1 );
        double speedBeforeBrake = getCurrentSpeed();
        decrementSpeed(amount);
        assert(speedBeforeBrake > getCurrentSpeed());

    }

}
