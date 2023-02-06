package dat3.car.cars;

import dat3.car.Entities.cars.Car;
import dat3.car.dto.cars.CarRequest;
import dat3.car.factories.cars.CarFactory;
import dat3.car.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarsCRUDTests {
    public CarsCRUDTests(){};

    @Test
    public void addCarToRepository()
    {
        Car car = null;
        try {
            car = addInitializedToDatabase();
        } catch (Exception e){
            fail();
        }
        var subject = repository.findByBrandLikeAndModelLike(car.getBrand(), car.getModel());
        assertEquals(car.getId(), subject.getId());
    }

    @Test
    public void removeCarFromDatabase()
    {
        Car car = null;
        try {
            car = addInitializedToDatabase();
            repository.delete(car);
        } catch (Exception e){
            fail();
        }
        var optional = repository.findById(car.getId());
        assertFalse(optional.isPresent());
    }

    @Test
    public void updateCarFromDatabase()
    {
        var request = new CarRequest("Tesla","Model Y");
        Car car = null;
        try {
            car = addInitializedToDatabase();
            request.setCarId(car.getId());
            repository.updateCarDetails(request.getBrand(),request.getModel(),request.getCarId());
        } catch (Exception e){
            fail();
        }
        var optional = repository.findById(car.getId());
        if(!optional.isPresent())
            fail();
        var subject = optional.get();
        assertEquals(subject.getBrand(),request.getBrand());
        assertEquals(subject.getModel(),request.getModel());
    }

    private Car addInitializedToDatabase() {
        var brand = "Fiat";
        var model = "Duna 70";
        var car = factory.car(brand,model,150);
        car = repository.save(car);
        return car;
    }

    // Test entities
    @Autowired
    private CarFactory factory;
    @Autowired
    private CarRepository repository;
}
