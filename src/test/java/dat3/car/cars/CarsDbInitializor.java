package dat3.car.cars;

import dat3.car.Entities.cars.Car;
import dat3.car.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarsDbInitializor {
    public CarsDbInitializor(CarRepository repository) {
        _repository = repository;
    }

    public void init()
    {
        var batch = cars();
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

    private List<Car> cars()
    {
        return new ArrayList<>() {
            {
                add(car("Volkswagen", "ID.4"));
                add(car("Ford", "Escord RS2000"));
                add(car("Nissan", "Shitbox model 1983"));
                add(car("Lada","500 classic"));
                add(car("Fiat","Duna 70"));
            }
        };
    }

    private Car car(String brand, String model)
    {
        var rand = new Random();
        var price = rand.nextDouble(9000) + 1000;
        return new Car(brand,model,price);
    }

    private final CarRepository _repository;
}
