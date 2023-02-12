package dat3.car.api;

import dat3.car.Entities.cars.CarRestricted;

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

    @PostMapping("/cars/addCar")
    public ResponseEntity<String> addCar(@RequestBody CarRestricted request)
    {
        return cars.add(request);
    }

    @GetMapping("/cars/car")
    public ResponseEntity<String> car(@RequestParam String id){
        return cars.get(id);
    }

    @PostMapping("/cars/removeCar")
    public ResponseEntity<String> removeCar(@RequestParam String id)
    {
        return cars.remove(id);
    }

    @PatchMapping("/cars/updateCar")
    public ResponseEntity<String> updateCar(@RequestBody CarRestricted request)
    {
        return cars.update(request);
    }

    private final Cars cars;
}
