package dat3.car.reservations.services;

import dat3.car.reservations.dtos.ReservationRequest;
import dat3.car.reservations.factories.ReservationsFactory;
import dat3.car.reservations.repositories.IReservationRepository;
import dat3.car.shared.services.Http.IHttpResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarReservationManager {
    public CarReservationManager(CarReservation carReserve, IHttpResult<String> result, ReservationsFactory factory, IReservationRepository reservations) {
        _carReserve = carReserve;
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

    public ResponseEntity<String> reserve(ReservationRequest request) {
        try {
            _carReserve.reserve(request);
        } catch (EntityNotFoundException e){
            return _result.notFound(e.getMessage());
        } catch (CarReserveFailedException e){
            return _result.notUpdated(e.getMessage());
        }
        return _result.created();
    }

    public ResponseEntity<String> unReserve(String id){
        try {
            _reservations.deleteById(id);
        } catch (Exception e){
            return _result.notFound("Reservation with given id not found");
        }
        return _result.ok();
    }

    private final CarReservation _carReserve;
    private final IHttpResult<String> _result;
    private final ReservationsFactory _factory;
    private final IReservationRepository _reservations;
}
