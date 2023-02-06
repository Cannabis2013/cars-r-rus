package dat3.car.cars;

import dat3.car.Entities.cars.Car;
import dat3.car.factories.cars.CarFactory;
import dat3.car.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarsBasicAcceptanceTests {
    public CarsBasicAcceptanceTests(){};

    @Test
    public void addCarToRepository()
    {
        var brand = "Fiat";
        var model = "Duna 70";
        car = factory.car(brand,model,150);

        String id = "";
        try {
            id = repository.save(car).getId();
        } catch (Exception e){
            fail();
        }
        var subject = repository.findByBrandLikeAndModelLike(brand,model);
        assertEquals(id, subject.getId());
    }

    @Test
    public void removeCarFromDatabase()
    {
        try {
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

    // Test entities
    private Car car;
    @Autowired
    private CarFactory factory;
    @Autowired
    private CarRepository repository;
}
