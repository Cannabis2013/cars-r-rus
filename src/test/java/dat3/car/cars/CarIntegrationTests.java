package dat3.car.cars;

/*
    Tests that passes all layers
 */

import dat3.car.cars.factories.ImageBase64Converter;
import dat3.car.cars.dtos.CarsAddRequest;
import dat3.car.cars.factories.CarFactory;
import dat3.car.cars.repositories.ICarRepository;
import dat3.car.shared.services.Http.HttpJsonResult;
import dat3.car.cars.services.CarManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CarIntegrationTests {
    @BeforeEach
    public void init()
    {
        _carManager = new CarManager(new HttpJsonResult(),_repository,new CarFactory(new ImageBase64Converter()));
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
