import java.awt.*;

abstract public class Car implements Movable{

    private double posX;
    private double posY;
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
        assert(currentSpeed > 0 && currentSpeed < enginePower);
        if(direction == 0){
            posX += currentSpeed;
        }else if(direction == 1){
            posY += currentSpeed;
        }else if(direction == 2){
            posX -= currentSpeed;
        }else if(direction == 3) {
            posY -= currentSpeed;
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

}

