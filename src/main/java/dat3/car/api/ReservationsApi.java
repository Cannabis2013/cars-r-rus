package dat3.car.api;

import dat3.car.dto.reservations.ReservationRequest;
import dat3.car.services.reservations.CarReservationManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationsApi {
    public ReservationsApi(CarReservationManager carReservations) {
        _reservationManager = carReservations;
    }

    @GetMapping("/all")
    public ResponseEntity<String> all()
    {
        return _reservationManager.reservations();
    }

    @GetMapping("/one")
    public ResponseEntity<String> one(@RequestParam String id){
        return _reservationManager.reservation(id);
    }

    @PostMapping("/reserve")
    public ResponseEntity<String> reserve(@RequestBody ReservationRequest request){
        return _reservationManager.reserve(request);
    }

    @PostMapping("/unReserve")
    public ResponseEntity<String> unReserve(@RequestParam String id){
        return _reservationManager.unReserve(id);
    }

    private final CarReservationManager _reservationManager;
}
