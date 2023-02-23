package dat3.car.cars;

/*
    Tests that passes all layers
 */

import dat3.car.dto.cars.CarsAddRequest;
import dat3.car.factories.cars.CarFactory;
import dat3.car.repository.ICarRepository;
import dat3.car.services.Http.HttpJsonResult;
import dat3.car.services.cars.CarManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CarManagerIntegrationTests {
    @BeforeEach
    public void init()
    {
        _carManager = new CarManager(new HttpJsonResult(),_repository,new CarFactory());
        _initializor.init(_repository);
    }

    @AfterEach
    public void cleanUp()
    {
        _initializor.clear(_repository);
    }
    @Test
    public void addCarToDatabase()
    {
        var car = new CarsAddRequest("Tesla ","Modex X",25,0);
        var response = _carManager.add(car);
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }

    @Test
    public void removeCarFromRequest(){
        var car = _initializor.randomCar(_repository);
        var response = _carManager.remove(car.getId());
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    private CarManager _carManager;

    private final CarsDbInitializor _initializor = new CarsDbInitializor();
    @Autowired
    private ICarRepository _repository;
}
