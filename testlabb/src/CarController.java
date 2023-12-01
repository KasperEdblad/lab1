import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car thiscar : cars) {
                thiscar.move();

                int carX = (int) Math.round(thiscar.getPosX());
                int carY = (int) Math.round(thiscar.getPosY());


                if (thiscar instanceof Volvo240) {
                    frame.drawPanel.moveVolvo(carX, carY);
                    System.out.println("Volvo: " + thiscar.getCurrentSpeed());
                    System.out.println("Volvo: " + thiscar.getPosX());
                    System.out.println("y" + thiscar.getPosY());

                }
                else if (thiscar instanceof Saab95) {

                    frame.drawPanel.moveSaab(carX, carY);
                    System.out.println("Saab: " + thiscar.getCurrentSpeed());
                    System.out.println("Saab: " + thiscar.getPosX());
                }


                else if (thiscar instanceof Scania) {

                    frame.drawPanel.moveScania(carX, carY);
                    System.out.println("Scania: " + thiscar.getCurrentSpeed());
                    System.out.println("Scania: " + thiscar.getPosX());
                }


                if(thiscar.getPosX() + 118 > frame.getX()){
                    thiscar.setPosX(frame.getX() - 118);
                    thiscar.stopEngine();
                    thiscar.turnRight();
                    thiscar.turnRight();
                    thiscar.startEngine();
                } else if (thiscar.getPosX() < 0) {
                    thiscar.setPosX(0);
                    thiscar.stopEngine();
                    thiscar.turnRight();
                    thiscar.turnRight();
                    thiscar.startEngine();
                }


            }



            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 10;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
}