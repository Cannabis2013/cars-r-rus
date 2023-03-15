package dat3.car.reservations.services;

import dat3.car.reservations.dtos.ReservationRequest;
import dat3.car.cars.entities.Car;
import dat3.car.members.entities.Member;
import dat3.car.reservations.entities.Reservation;
import dat3.car.reservations.factories.ReservationsFactory;
import dat3.car.cars.repositories.ICarRepository;
import dat3.car.members.repositories.IMemberRepository;
import dat3.car.reservations.repositories.IReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarReservation {
    public CarReservation(IReservationRepository reservations, ReservationsFactory factory, ICarRepository cars, IMemberRepository members) {
        _reservations = reservations;
        _factory = factory;
        _cars = cars;
        _members = members;
    }

    public void reserve(ReservationRequest request) throws EntityNotFoundException, CarReserveFailedException {
        var member = _members.findById(request.getMemberId()).orElseThrow(() -> new EntityNotFoundException("Member with given id not found"));
        var car = _cars.findById(request.getCarId()).orElseThrow(() -> new EntityNotFoundException("Car with given id not found"));
        addToDatabase(car,member,request);
    }

    private void addToDatabase(Car car, Member member, ReservationRequest request) throws CarReserveFailedException {
        if(alreadyReserved(car.getReservations(),request.getReservationStart(),request.getReservationEnd()))
            throw new CarReserveFailedException("Car already reserved");
        var reservation = _factory.fromRequest(request,car,member);
        try {
            _reservations.save(reservation);
        } catch (Exception e){
            throw new CarReserveFailedException("Car reservation failed");
        }
    }

    private boolean alreadyReserved(List<Reservation> reservations, LocalDateTime start, LocalDateTime end)
    {
        return reservations.stream().anyMatch(r ->
                !r.getReservationStart().isAfter(end) &&
                !r.getReservationEnd().isBefore(start));
    }


    private final IReservationRepository _reservations;
    private final ReservationsFactory _factory;
    private final ICarRepository _cars;
    private final IMemberRepository _members;
}
