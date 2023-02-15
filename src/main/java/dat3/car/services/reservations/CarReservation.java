package dat3.car.services.reservations;

import dat3.car.entities.cars.Car;
import dat3.car.entities.reservations.Reservation;
import dat3.car.SLA.Http.IHttpResult;
import dat3.car.dto.reservations.ReservationRequest;
import dat3.car.factories.reservations.ReservationsFactory;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarReservation {
    public CarReservation(IHttpResult<String> respone, ReservationsFactory _factory, CarRepository _cars, MemberRepository _members) {
        _result = respone;
        this._factory = _factory;
        this._cars = _cars;
        this._members = _members;
    }

    public ResponseEntity<String> reserve(ReservationRequest request) {
        if(!_members.existsById(request.memberId()))
            return _result.notFound("Member with given id not found");
        var car = _cars.findById(request.carId()).orElse(null);
        if(car == null)
            return _result.notFound();
        return addToDatabase(car,request);
    }

    private ResponseEntity<String> addToDatabase(Car car, ReservationRequest request){
        if(alreadyReserved(car.getReservations(),request.start(),request.end()))
            return _result.notUpdated("Car not available");
        var reservation = _factory.reservation(request.start(),request.end(),request.memberId());
        car.getReservations().add(reservation);
        try {
            _cars.save(car);
        } catch (Exception e){
            return _result.notUpdated("Reservation failed!");
        }
        return _result.created(reservation);
    }

    private boolean alreadyReserved(List<Reservation> reservations, LocalDate start, LocalDate end)
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
    private final MemberRepository _members;
}
