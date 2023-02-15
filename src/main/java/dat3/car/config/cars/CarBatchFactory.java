package dat3.car.config.cars;

import dat3.car.entities.cars.Car;
import dat3.car.entities.reservations.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
                add(car("Volkswagen", "ID.4",false));
                add(car("Ford", "Escord RS2000",false));
                add(car("Nissan", "Shitbox model 1983",false));
                add(car("Lada","500 classic",true));
                add(car("Fiat","Duna 70",false));
            }
        };
    }

    private Car car(String brand, String model, boolean addReservation)
    {
        var rand = new Random();
        var price = rand.nextDouble(9000) + 1000;
        var car = new Car(brand,model,price);
        if(addReservation)
            car.getReservations().add(reservation(car));
        return car;
    }

    private Reservation reservation(Car car){
        var start = LocalDate.of(2023,6,3);
        var end = LocalDate.of(2023,9,3);
        return Reservation.builder().start(start).end(end)
                .memberId("").car(car).build();
    }
}
