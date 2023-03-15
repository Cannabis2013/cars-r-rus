package dat3.car.config.dbInit.reservations;

import dat3.car.cars.entities.Car;
import dat3.car.cars.repositories.ICarRepository;
import dat3.car.members.entities.Member;
import dat3.car.members.repositories.IMemberRepository;
import dat3.car.reservations.entities.Reservation;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


@Service
public class ReservationsConfigFactory {
    public ReservationsConfigFactory(ICarRepository cars, IMemberRepository members) {
        _cars = cars;
        _members = members;
    }

    public Reservation reserve(List<Car> cars, List<Member> members){
        var randomCar = fetchRandom(cars);
        var randomMember = fetchRandom(members);
        var actualCar = _cars.findById(randomCar.getId()).orElse(null);
        var actualMember = _members.findById(randomMember.getId()).orElse(null);
        return buildReservation(actualCar,actualMember);
    }

    private <TEntity> TEntity fetchRandom(List<TEntity> entities){
        Collections.shuffle(entities);
        return entities.get(0);
    }

    private Reservation buildReservation(Car car, Member member){
        var reservation = new Reservation();
        reservation.setReservationStart(LocalDateTime.now().minusDays(3));
        reservation.setReservationEnd(LocalDateTime.now().plusDays(3));
        reservation.setCar(car);
        reservation.setMemberId(member.getId());
        return reservation;
    }

    private final ICarRepository _cars;
    private final IMemberRepository _members;
}
