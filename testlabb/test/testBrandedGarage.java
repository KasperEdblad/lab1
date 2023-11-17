import org.junit.Before;
import org.junit.Test;

public class testBrandedGarage {

    private Garage<Car> unbrandedGarage;
    private Garage<Saab95> saab95Garage;



    @Before
    public void init(){
        unbrandedGarage = new Garage<Car>(5,400,400);
        saab95Garage = new Garage<Saab95>(7,250,250);
    }

    @Test
    public void testLoadAndUnloadCar(){
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        volvo.setPosX(380);
        volvo.setPosY(380);
        unbrandedGarage.loadCar(volvo);
        assert(unbrandedGarage.carsInGarage.contains(volvo));
        assert(unbrandedGarage.carsInGarage.size() == 1 );

        saab.setPosX(230);
        saab.setPosY(230);
        saab95Garage.loadCar(saab);
        assert(saab95Garage.carsInGarage.contains(saab));
        assert(saab95Garage.carsInGarage.size() == 1);
        saab95Garage.unloadCar(saab);
        assert(saab95Garage.carsInGarage.isEmpty());


        saab.setPosX(430);
        saab.setPosY(430);
        unbrandedGarage.loadCar(saab);
        assert(unbrandedGarage.carsInGarage.contains(saab));
        assert(unbrandedGarage.carsInGarage.size() == 2);
    }
}
