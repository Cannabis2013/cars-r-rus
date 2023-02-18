package dat3.car.api;

import dat3.car.dto.reservations.ReservationRequest;
import dat3.car.services.reservations.CarReservate;
import dat3.car.services.reservations.CarReservations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationsApi {
    public ReservationsApi(CarReservate reservation, CarReservations carReservations) {
        _carReservation = reservation;
        _carReservations = carReservations;
    }

    @GetMapping("/all")
    public ResponseEntity<String> all()
    {
        return _carReservations.reservations();
    }

    @GetMapping("/one")
    public ResponseEntity<String> one(@RequestParam String id){
        return _carReservations.reservation(id);
    }

    @PostMapping("/reserve")
    public ResponseEntity<String> reserve(@RequestBody ReservationRequest request){
        return _carReservation.reserve(request);
    }

    private final CarReservate _carReservation;
    private final CarReservations _carReservations;
}
