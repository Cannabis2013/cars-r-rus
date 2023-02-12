package dat3.car.cars;

import dat3.car.Entities.cars.CarUnrestricted;
import dat3.car.repository.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarsRepositoryTests {
    public CarsRepositoryTests(){};

    @BeforeEach
    public void init(){
        _initializor.init();
    }

    @AfterEach
    public void cleanUp()
    {
        _initializor.clear();
    }

    @Test
    public void addCarToRepository()
    {
        var car = Assertions.assertDoesNotThrow(this::addNissanSkyline);
        var subject = repository.findByBrandLikeAndModelLike(car.getBrand(), car.getModel());
        assertEquals(car.getId(), subject.getId());
    }

    @Test
    public void removeCarFromDatabase()
    {
        CarUnrestricted car = null;
        try {
            car = addNissanSkyline();
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
        var newBrand = "Tesla";
        var newModel = "Model Y";
        var car = repository.findByBrandLikeAndModelLike("Lada","500 classic");
        assertDoesNotThrow(() -> repository.updateCarDetails(newBrand,newModel,car.getId()));
        var subject = repository.findById(car.getId()).orElseThrow(AssertionFailedError::new);
        assertEquals(newBrand,subject.getBrand());
        assertEquals(newModel,subject.getModel());
    }

    private CarUnrestricted addNissanSkyline() {
        var brand = "Nissan";
        var model = "Skyline GTR med ekstra kardanaksel";
        var car = new CarUnrestricted(brand,model,150);
        return repository.save(car);
    }

    @Autowired
    private CarRepository repository;

    @Autowired
    private CarsDbInitializor _initializor;
}
