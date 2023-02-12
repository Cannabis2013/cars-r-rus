package dat3.car.cars;

/*
    Tests that passes all layers
 */

import dat3.car.services.cars.Cars;
import org.junit.jupiter.api.AfterEach;
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
        var car = _builder.teslaModelX();
        var response = _cars.add(car);
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }

    @Test
    public void removeCarFromRequest(){
        var car = _initializor.randomCar();
        var response = _cars.remove(car.getId());
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Autowired
    private Cars _cars;
    @Autowired
    private CarBatchBuilder _builder;
    @Autowired
    private CarsDbInitializor _initializor;
}
