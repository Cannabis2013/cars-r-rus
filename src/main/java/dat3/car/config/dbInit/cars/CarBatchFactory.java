package dat3.car.config.dbInit.cars;

import dat3.car.entities.cars.Car;
import dat3.car.entities.reservations.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CarBatchFactory {
    public List<Car> batch()
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
        var car = new Car(brand,model,price);
        return car;
    }
}
