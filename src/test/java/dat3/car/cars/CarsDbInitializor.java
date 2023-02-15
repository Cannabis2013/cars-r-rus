package dat3.car.cars;

import dat3.car.entities.cars.Car;
import dat3.car.repository.CarRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarsDbInitializor {
    public void init(JpaRepository<Car,String> repository)
    {
        var batch = batch();
        repository.saveAll(batch);
    }

    public void clear(JpaRepository<Car,String> repository)
    {
        repository.deleteAll();
    }

    public Car randomCar(CarRepository repository)
    {
        var cars = repository.findAll();
        var random = new Random();
        var i = random.nextInt(cars.size());
        return cars.get(i);
    }

    private List<Car> batch()
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
}
