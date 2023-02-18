package dat3.car.services.reservations;

import dat3.car.dto.reservations.ReservationRequest;
import dat3.car.entities.cars.Car;
import dat3.car.entities.members.Member;
import dat3.car.entities.reservations.Reservation;
import dat3.car.factories.reservations.ReservationsFactory;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import dat3.car.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarReservation {
    public CarReservation(ReservationRepository reservations, ReservationsFactory factory, CarRepository cars, MemberRepository members) {
        _reservations = reservations;
        _factory = factory;
        _cars = cars;
        _members = members;
    }

    private void addToDatabase(Car car, Member member, ReservationRequest request) throws CarReserveFailedException {
        if(alreadyReserved(car.getReservations(),request.getStart(),request.getEnd()))
            throw new CarReserveFailedException("Car already reserved");
        var reservation = _factory.fromRequest(request,car,member);
        try {
            _reservations.save(reservation);
        } catch (Exception e){
            throw new CarReserveFailedException("Car reservation failed");
        }
    }

    public void reserve(ReservationRequest request) throws EntityNotFoundException, CarReserveFailedException {
        var member = _members.findById(request.getMemberId()).orElseThrow(() -> new EntityNotFoundException("Member with given id not found"));
        var car = _cars.findById(request.getCarId()).orElseThrow(() -> new EntityNotFoundException("Car with given id not found"));
        addToDatabase(car,member,request);
    }

    private boolean alreadyReserved(List<Reservation> reservations, LocalDateTime start, LocalDateTime end)
    {
        for (var reservation : reservations){
            if(!reservation.getStart().isAfter(end) && !reservation.getEnd().isBefore(start))
                return true;
        }
        return false;
    }


    private final ReservationRepository _reservations;
    private final ReservationsFactory _factory;
    private final CarRepository _cars;
    private final MemberRepository _members;
}
