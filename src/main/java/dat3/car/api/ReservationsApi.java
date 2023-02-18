package dat3.car.api;

import dat3.car.dto.reservations.ReservationRequest;
import dat3.car.services.reservations.CarReservation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationsApi {
    public ReservationsApi(CarReservation reservation) {
        _reservation = reservation;
    }

    @GetMapping()
    public ResponseEntity<String> all()
    {
        return _reservation.reservations();
    }

    @PostMapping("/reserve")
    public ResponseEntity<String> reserve(@RequestBody ReservationRequest request){
        return _reservation.reserve(request);
    }

    private final CarReservation _reservation;
}
