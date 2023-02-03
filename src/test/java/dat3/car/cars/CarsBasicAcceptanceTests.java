package dat3.car.cars;

import dat3.car.factories.cars.CarFactory;
import dat3.car.repository.CarRepository;
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
        var car = factory.build(brand,model,150);

        String id = "";
        try {
            id = repository.save(car).getId();
        } catch (Exception e){
            fail();
        }
        var subject = repository.findByBrandLikeAndModelLike(brand,model);
        assertEquals(id, subject.getId());
    }

    @Autowired
    private CarFactory factory;
    @Autowired
    private CarRepository repository;
}
