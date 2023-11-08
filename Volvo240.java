import java.awt.*;

public class Volvo240 extends Car implements movable{

    private final static double trimFactor = 1.25;

    public Volvo240(){
        x = 100;
        y = 100;
        point = new point(x,y)
        nrDoors = 4;
        setColor(Color.black);
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    private double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
