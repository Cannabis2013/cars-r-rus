package dat3.car.cars;

import dat3.car.cars.CarsDbInitializor;
import dat3.car.entities.cars.Car;
import dat3.car.repository.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CarsRepositoryTests {
    @BeforeEach
    public void init(){
        _initializor.init(_repository);
    }

    @AfterEach
    public void cleanUp()
    {
        _initializor.clear(_repository);
    }

    @Test
    public void addCarToRepository()
    {
        var car = Assertions.assertDoesNotThrow(this::addNissanSkyline);
        var subject = _repository.findByBrandLikeAndModelLike(car.getBrand(), car.getModel());
        assertEquals(car.getId(), subject.getId());
    }

    @Test
    public void removeCarFromDatabase()
    {
        Car car = null;
        try {
            car = addNissanSkyline();
            _repository.delete(car);
        } catch (Exception e){
            fail();
        }
        var optional = _repository.findById(car.getId());
        assertFalse(optional.isPresent());
    }

    @Test
    public void updateCarFromDatabase()
    {
        var newBrand = "Tesla";
        var newModel = "Model Y";
        var car = _repository.findByBrandLikeAndModelLike("Lada","500 classic");
        car.setBrand(newBrand);
        car.setModel(newModel);
        assertDoesNotThrow(() -> _repository.save(car));
        var subject = _repository.findById(car.getId()).orElseThrow(AssertionFailedError::new);
        assertEquals(newBrand,subject.getBrand());
        assertEquals(newModel,subject.getModel());
    }

    private Car addNissanSkyline() {
        var brand = "Nissan";
        var model = "Skyline GTR med ekstra kardanaksel";
        var car = new Car(brand,model,150);
        return _repository.save(car);
    }

    @Autowired
    private CarRepository _repository;

    private final CarsDbInitializor _initializor = new CarsDbInitializor();
}
