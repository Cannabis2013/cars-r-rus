package dat3.car.cars;

import dat3.car.Entities.cars.CarRestricted;
import dat3.car.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarsDbInitializor {
    public CarsDbInitializor() {
        _batchFactory = new TESTCarBatchFactory();
    }

    public void init(CarRepository repository)
    {
        var batch = _batchFactory.batch();
        repository.saveAll(batch);
    }

    public void clear(CarRepository repository)
    {
        repository.deleteAll();
    }

    public CarRestricted randomCar(CarRepository repository)
    {
        var cars = repository.findAll();
        var random = new Random();
        var i = random.nextInt(cars.size());
        return cars.get(i);
    }

    private final TESTCarBatchFactory _batchFactory;
}
