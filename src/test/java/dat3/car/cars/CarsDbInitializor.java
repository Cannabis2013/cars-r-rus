package dat3.car.cars;

import dat3.car.cars.entities.Car;
import dat3.car.cars.repositories.ICarRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

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

    public Car randomCar(ICarRepository repository)
    {
        var cars = repository.findAll();
        Collections.shuffle(cars);
        return cars.get(0);
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
