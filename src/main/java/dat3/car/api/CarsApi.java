package dat3.car.api;

import dat3.car.dto.cars.CarRequest;
import dat3.car.services.cars.Cars;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarsApi {
    public CarsApi(Cars carContext) {
        this.cars = carContext;
    }

    @GetMapping("/cars")
    public ResponseEntity<String> cars(){
        return cars.all();
    }

    @GetMapping("/cars/car")
    public ResponseEntity<String> car(@RequestParam String id){
        return cars.get(id);
    }

    @PostMapping("/cars/addCar")
    public ResponseEntity<String> addCar(@RequestBody CarRequest car)
    {
        return cars.add(car);
    }

    @PostMapping("/cars/removeCar")
    public ResponseEntity<String> removeCar(@RequestParam String id)
    {
        return cars.remove(id);
    }

    private final Cars cars;
}
