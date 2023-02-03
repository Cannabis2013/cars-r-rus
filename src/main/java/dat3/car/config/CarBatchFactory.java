package dat3.car.config;

import dat3.car.Entities.cars.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarBatchFactory {
    public List<Car> cars()
    {
        return new ArrayList<>() {
            {
                add(new Car("Volkswagen", "ID.4", 2500));
                add(new Car("Ford", "Escord RS2000", 4500));
                add(new Car("Nissan", "Shitbox model 1983", 300));
            }
        };
    }
}
