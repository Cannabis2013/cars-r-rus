package dat3.car.services.reservations;

import dat3.car.entities.cars.Car;
import dat3.car.entities.members.Member;
import dat3.car.entities.reservations.Reservation;
import dat3.car.SLA.Http.IHttpResult;
import dat3.car.dto.reservations.ReservationRequest;
import dat3.car.factories.reservations.ReservationsFactory;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import dat3.car.repository.ReservationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarReservation {
    public CarReservation(IHttpResult<String> respone, ReservationsFactory _factory, CarRepository _cars, ReservationRepository reservations, MemberRepository _members) {
        _result = respone;
        this._factory = _factory;
        this._cars = _cars;
        _reservations = reservations;
        this._members = _members;
    }

    public ResponseEntity<String> reservations()
    {
        var reservations = _reservations
                .findAll();
        var response = reservations.stream().map(_factory::toResponse).toList();
        return _result.ok(response);
    }

    public ResponseEntity<String> reserve(ReservationRequest request) {
        var member = _members.findById(request.getMemberId()).orElse(null);
        if(member == null)
            return _result.notFound("Member with given id not found");
        var car = _cars.findById(request.getCarId()).orElse(null);
        if(car == null)
            return _result.notFound("Car with given id not found");
        return addToDatabase(car,member,request);
    }

    private ResponseEntity<String> addToDatabase(Car car, Member member, ReservationRequest request){
        if(alreadyReserved(car.getReservations(),request.getStart(),request.getEnd()))
            return _result.notUpdated("Car not available");
        var reservation = _factory.fromRequest(request,car,member);
        car.getReservations().add(reservation);
        try {
            _cars.save(car);
        } catch (Exception e){
            return _result.notUpdated("Reservation failed!");
        }
        return _result.created(_factory.toResponse(reservation));
    }

    private boolean alreadyReserved(List<Reservation> reservations, LocalDateTime start, LocalDateTime end)
    {
        for (var reservation : reservations){
            if(!reservation.getStart().isAfter(end) && !reservation.getEnd().isBefore(start))
                return true;
        }
        return false;
    }

    private final IHttpResult<String> _result;
    private final ReservationsFactory _factory;
    private final CarRepository _cars;

    private final ReservationRepository _reservations;
    private final MemberRepository _members;
}
