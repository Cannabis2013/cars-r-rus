package dat3.car.reservations.services;

import dat3.car.members.repositories.IMemberRepository;
import dat3.car.reservations.dtos.ReservationRequest;
import dat3.car.reservations.factories.ReservationsFactory;
import dat3.car.reservations.repositories.IReservationRepository;
import dat3.car.shared.services.Http.IHttpResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarReservationManager {
    public CarReservationManager(CarReservation carReserve, IHttpResult<String> result, ReservationsFactory factory, IReservationRepository reservations, IMemberRepository memberRepository) {
        _carReserve = carReserve;
        _result = result;
        _factory = factory;
        _reservations = reservations;
        _members = memberRepository;
    }

    public ResponseEntity<String> reservations()
    {
        var reservations = _reservations.findAll();
        var response = reservations.stream().map(r -> {
            var member = _members.findByIdLike(r.getMemberId()).orElse(null);
            if(member != null)
                return _factory.toResponse(r,member);
            return null;
        }).toList();
        return _result.ok(response);
    }

    public ResponseEntity<String> reservations(String memberName){
        var member = _members.findByUsernameLike(memberName).orElse(null);
        if(member == null)
            return _result.notFound("Associated member not found");
        var reservations = _reservations.findByMemberId(member.getId());
        var response = reservations.stream().map(r -> _factory.toResponse(r,member)).toList();
        return _result.ok(response);
    }

    public ResponseEntity<String> reservation(String id){
        var reservation = _reservations.findById(id).orElse(null);
        if(reservation == null)
            return _result.notFound("Reservation with given id not found");
        var member = _members.findByIdLike(reservation.getMemberId());
        if(member.isEmpty())
            return _result.notFound("Associated member not found");
        var response = _factory.toResponse(reservation,member.get());
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
    private final IMemberRepository _members;
}
