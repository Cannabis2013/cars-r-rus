package dat3.car.api;

import dat3.car.dto.cars.CarUpdateRequest;
import dat3.car.dto.cars.CarsAddRequest;

import dat3.car.dto.reservations.ReservationRequest;
import dat3.car.services.cars.Cars;
import dat3.car.services.reservations.CarReservation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarsApi {
    public CarsApi(Cars carContext, CarReservation reservation) {
        this._cars = carContext;
        this._reservation = reservation;
    }

    @GetMapping("/cars")
    public ResponseEntity<String> cars(){
        return _cars.all();
    }

    @PostMapping("/cars/addCar")
    public ResponseEntity<String> addCar(@RequestBody CarsAddRequest request)
    {
        return _cars.add(request);
    }

    @GetMapping("/cars/car")
    public ResponseEntity<String> car(@RequestParam String id){
        return _cars.get(id);
    }

    @PostMapping("/cars/removeCar")
    public ResponseEntity<String> removeCar(@RequestParam String id)
    {
        return _cars.remove(id);
    }

    @PatchMapping("/cars/updateCar")
    public ResponseEntity<String> updateCar(@RequestBody CarUpdateRequest request)
    {
        return _cars.update(request);
    }

    @PostMapping("/cars/reserve")
    public ResponseEntity<String> reserve(@RequestBody ReservationRequest request){
        return _reservation.reserve(request);

    }

    private final Cars _cars;
    private final CarReservation _reservation;
}
