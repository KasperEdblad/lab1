import java.awt.*;
abstract public class Truck extends Car {

    private final static double trimFactor = 1.25;
    private int flatbedAngle;

    public Truck(double posX, double posY, int direction, int nrDoors, double enginepower, Color color, String modelName, int flatbedAngle) {
        super(posX, posY, direction, nrDoors, enginepower, color, modelName);
        this.flatbedAngle = flatbedAngle;
    }


    public void startEngine() {
        assert (flatbedAngle == 0);
        currentSpeed = 0.1;
    }

    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void gas(double amount) {
        assert (amount > 0 && amount < 1);
        double speedBeforeGas = getCurrentSpeed();
        incrementSpeed(amount);
        assert (speedBeforeGas < getCurrentSpeed());
    }

    public void brake(double amount) {
        assert (amount > 0 && amount < 1);
        double speedBeforeBrake = getCurrentSpeed();
        decrementSpeed(amount);
        assert (speedBeforeBrake > getCurrentSpeed());
    }

    public int getFlatbedAngle() {
        return flatbedAngle;
    }

    public void setFlatbedAngle(int angle) {
        assert (angle >= 0 && angle <= 70);
        flatbedAngle = angle;
    }

    public void raiseFlatbed() {
        assert (currentSpeed == 0);
        if (flatbedAngle < 70) {
            flatbedAngle += 1;
        }
    }

    public void lowerFlatbed() {
        assert (currentSpeed == 0);
        if (flatbedAngle > 0) {
            flatbedAngle -= 1;
        }

    }

}

