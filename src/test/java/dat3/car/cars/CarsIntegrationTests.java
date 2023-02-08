package dat3.car.cars;

/*
    Tests that passes all layers
 */

import dat3.car.Entities.cars.Car;
import dat3.car.factories.cars.CarFactory;
import dat3.car.repository.CarRepository;
import dat3.car.services.cars.Cars;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class CarsIntegrationTests {
    @Test
    public void addCarFromRequest()
    {
        var req = _builder.request();
        var response = _cars.add(req);
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }

    @Test
    public void removeCarFromRequest(){
        var car = addTestCarToRepository("Ford","A");
        if(car == null)
            fail();
        var response = _cars.remove(car.getId());
        assertEquals(HttpStatus.OK,response.getStatusCode());

    }

    private Car addTestCarToRepository(String brand, String model)
    {
        var car = new Car(brand,model,2490);
        Car savedCar;
        try {
            savedCar = _repository.save(car);
        } catch (Exception e){
            return null;
        }
        return savedCar;
    }

    private Car addInitializedToDatabase() {
        var brand = "Fiat";
        var model = "Duna 70";
        var car = new Car(brand,model,150);
        car = _repository.save(car);
        return car;
    }

    @Autowired
    private CarRepository _repository;
    @Autowired
    private CarFactory _factory;
    @Autowired
    private Cars _cars;
    @Autowired
    private CarBatchBuilder _builder;
}
