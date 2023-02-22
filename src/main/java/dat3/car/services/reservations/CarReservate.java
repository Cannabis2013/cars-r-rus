package dat3.car.services.reservations;

import dat3.car.dto.reservations.ReservationRequest;
import dat3.car.repository.ReservationRepository;
import dat3.car.contracts.Http.IHttpResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarReservate {
    public CarReservate(IHttpResult<String> respone, ReservationRepository reservations, CarReservation carReserve) {
        _result = respone;
        _reservations = reservations;
        _carReserve = carReserve;
    }

    public ResponseEntity<String> reserve(ReservationRequest request) {
        try {
            _carReserve.reserve(request);
        } catch (EntityNotFoundException e){
            return _result.notFound(e.getMessage());
        } catch (CarReserveFailedException e){
            return _result.notUpdated(e.getMessage());
        }
        return _result.ok();
    }

    public ResponseEntity<String> unReserve(String id){
        try {
            _reservations.deleteById(id);
        } catch (Exception e){
            return _result.notFound("Reservation with given id not found");
        }
        return _result.ok();
    }

    private final IHttpResult<String> _result;
    private final ReservationRepository _reservations;
    private final CarReservation _carReserve;
}
