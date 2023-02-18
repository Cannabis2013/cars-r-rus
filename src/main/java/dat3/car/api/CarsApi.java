package dat3.car.api;

import dat3.car.dto.cars.CarUpdateRequest;
import dat3.car.dto.cars.CarsAddRequest;

import dat3.car.services.cars.Cars;
import dat3.car.services.reservations.CarReservate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarsApi {
    public CarsApi(Cars carContext, CarReservate reservation) {
        this._cars = carContext;
    }

    @GetMapping("/all")
    public ResponseEntity<String> cars(){
        return _cars.all();
    }

    @GetMapping("/one")
    public ResponseEntity<String> car(@RequestParam String id){
        return _cars.get(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCar(@RequestBody CarsAddRequest request)
    {
        return _cars.add(request);
    }

    @PostMapping("remove")
    public ResponseEntity<String> removeCar(@RequestParam String id)
    {
        return _cars.remove(id);
    }

    @PatchMapping("update")
    public ResponseEntity<String> updateCar(@RequestBody CarUpdateRequest request)
    {
        return _cars.update(request);
    }

    private final Cars _cars;
}
