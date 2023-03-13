package dat3.car.cars.api;

import dat3.car.cars.dtos.CarUpdateRequest;
import dat3.car.cars.dtos.CarsAddRequest;

import dat3.car.cars.services.CarManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarsApi {
    public CarsApi(CarManager carContext) {
        this._carManager = carContext;
    }

    @GetMapping("/all")
    public ResponseEntity<String> cars(){
        return _carManager.all();
    }

    @GetMapping("/one")
    public ResponseEntity<String> car(@RequestParam String id){
        return _carManager.get(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCar(@RequestBody CarsAddRequest request)
    {
        return _carManager.add(request);
    }

    @PostMapping("remove")
    public ResponseEntity<String> removeCar(@RequestParam String id)
    {
        return _carManager.remove(id);
    }

    @PatchMapping("update")
    public ResponseEntity<String> updateCar(@RequestBody CarUpdateRequest request)
    {
        return _carManager.update(request);
    }

    private final CarManager _carManager;
}
