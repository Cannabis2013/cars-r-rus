package dat3.car.cars;

import dat3.car.Entities.cars.Car;
import dat3.car.factories.cars.CarFactory;
import dat3.car.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class CarsBasicAcceptanceTests {
    public CarsBasicAcceptanceTests(){};

    @Test
    public void addCarToRepository()
    {
        Car car = null;
        try {
            car = add();
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
            car = add();
            repository.delete(car);
        } catch (Exception e){
            System.out.println("**********");
            System.out.println(e.getMessage());
            System.out.println("//////////");
            fail();
        }
        var optional = repository.findById(car.getId());
        Assertions.assertFalse(optional.isPresent());
    }

    private Car add() {
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
