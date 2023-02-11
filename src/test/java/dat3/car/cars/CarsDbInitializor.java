package dat3.car.cars;

import dat3.car.Entities.cars.Car;
import dat3.car.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarsDbInitializor {
    public CarsDbInitializor(CarRepository repository, CarBatchFactory batchFactory) {
        _repository = repository;
        _batchFactory = batchFactory;
    }

    public void init()
    {
        var batch = _batchFactory.batch();
        _repository.saveAll(batch);
    }

    public void clear()
    {
        _repository.deleteAll();
    }

    public Car randomCar()
    {
        var cars = _repository.findAll();
        var random = new Random();
        var i = random.nextInt(cars.size());
        return cars.get(i);
    }

    private final CarRepository _repository;
    private final CarBatchFactory _batchFactory;
}
