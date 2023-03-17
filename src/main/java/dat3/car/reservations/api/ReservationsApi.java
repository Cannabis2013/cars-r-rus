package dat3.car.reservations.api;

import dat3.car.reservations.dtos.ReservationRequest;
import dat3.car.reservations.services.CarReservationManager;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationsApi {
    public ReservationsApi(CarReservationManager carReservations) {
        _reservationManager = carReservations;
    }

    @GetMapping("/all")
    public ResponseEntity<String> all()
    {
        return _reservationManager.reservations();
    }

    @GetMapping("/memberReservations")
    public ResponseEntity<String> all(@RequestParam String memberId){
        return _reservationManager.reservations(memberId);
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
