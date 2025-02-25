import java.awt.*;

abstract public class Car implements Movable{

    private static double posX;
    private static double posY;
    private int direction;
    private final int nrDoors;
    private final double enginePower;
    public double currentSpeed;
    private Color color;
    private final String modelName;

    public Car(double posX, double posY, int direction, int nrDoors, double enginePower, Color color, String modelName){
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.setColor(color);
        this.modelName = modelName;
        stopEngine();
    }

    public double getPosX(){
        return posX;
    }
    public double getPosY(){
        return posY;
    }
    public void setPosX(double pos){posX = pos;}
    public void setPosY(double pos){posY = pos;}
    public int getDirection(){
        return direction;
    }
    public void setDirection(int newDirection){
        direction = newDirection;
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color clr){
        color = clr;
    }
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }

    public void move(){
        if(currentSpeed <= 0){
            currentSpeed = 0;
        } else {
            if (currentSpeed > enginePower){
                currentSpeed = enginePower;
            }

            if (direction == 0) {
                posX += currentSpeed;
            } else if (direction == 1) {
                posY += currentSpeed;
            } else if (direction == 2) {
                posX -= currentSpeed;
            } else if (direction == 3) {
                posY -= currentSpeed;
            }
        }
    }
    public void turnLeft(){
        if(direction == 0){
            direction = 3;
        }
        else{
            direction -= 1;
        }
    }
    public void turnRight(){
        if(direction == 3){
            direction = 0;
        }
        else{
            direction += 1;
        }
    }

    abstract public double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void gas(double amount) {
        double speedBeforeGas = getCurrentSpeed();
        if(amount > 0 && amount <= 1 && currentSpeed > 0){
            incrementSpeed(amount);

            if(speedBeforeGas > getCurrentSpeed()){
                currentSpeed = speedBeforeGas;
            }
        }
    }

    public void brake(double amount){
        double speedBeforeBrake = getCurrentSpeed();
        if(amount > 0 && amount <= 1){
            decrementSpeed(amount);

            if(speedBeforeBrake < getCurrentSpeed()){
                currentSpeed = speedBeforeBrake;
            }
        }

    }

}