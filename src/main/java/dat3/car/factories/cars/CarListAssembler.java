package dat3.car.factories.cars;

import dat3.car.Entities.cars.Car;

import java.util.ArrayList;
import java.util.List;

public class CarListAssembler {
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
