package dat3.car.cars;

/*
    Tests that passes all layers
 */

import dat3.car.Entities.cars.Car;
import dat3.car.factories.cars.CarFactory;
import dat3.car.repository.CarRepository;
import dat3.car.services.cars.Cars;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class CarsIntegrationTests {
    @BeforeEach
    public void init()
    {
        _initializor.init();
    }

    @AfterEach
    public void cleanUp()
    {
        _initializor.clear();
    }
    @Test
    public void addCarFromRequest()
    {
        var req = _builder.teslaModelX();
        var response = _cars.add(req);
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }

    @Test
    public void removeCarFromRequest(){
        var car = _initializor.randomCar();
        var response = _cars.remove(car.getId());
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    private Car addTestCarToRepository(String brand, String model)
    {
        var car = new Car(brand,model,2490);
        Car savedCar = null;
        try {
            savedCar = _repository.save(car);
        } catch (Exception e){
            fail();
        }
        return savedCar;
    }

    @Autowired
    private CarRepository _repository;
    @Autowired
    private Cars _cars;
    @Autowired
    private CarBatchBuilder _builder;
    @Autowired
    private CarsDbInitializor _initializor;
}
