package dat3.car.config;

import dat3.car.Entities.cars.CarUnrestricted;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CarBatchFactory {
    public List<CarUnrestricted> batch()
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

    private CarUnrestricted car(String brand, String model)
    {
        var rand = new Random();
        var price = rand.nextDouble(9000) + 1000;
        return new CarUnrestricted(brand,model,price);
    }
}
