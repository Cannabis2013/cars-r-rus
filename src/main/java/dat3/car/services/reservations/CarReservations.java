package dat3.car.services.reservations;

import dat3.car.factories.reservations.ReservationsFactory;
import dat3.car.repository.ReservationRepository;
import dat3.car.contracts.Http.IHttpResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarReservations {
    public CarReservations(IHttpResult<String> result, ReservationsFactory factory, ReservationRepository reservations) {
        _result = result;
        _factory = factory;
        _reservations = reservations;
    }

    public ResponseEntity<String> reservations()
    {
        var reservations = _reservations.findAll();
        var response = reservations.stream().map(_factory::toResponse).toList();
        return _result.ok(response);
    }

    public ResponseEntity<String> reservation(String id){
        var reservation = _reservations.findById(id).orElse(null);
        if(reservation == null)
            return _result.notFound("Reservation with given id not found");
        var response = _factory.toResponse(reservation);
        return _result.ok(response);
    }

    private final IHttpResult<String> _result;
    private final ReservationsFactory _factory;
    private final ReservationRepository _reservations;
}
