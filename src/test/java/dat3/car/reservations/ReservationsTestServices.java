package dat3.car.reservations;

import dat3.car.cars.CarsDbInitializor;
import dat3.car.reservations.entities.Reservation;
import dat3.car.reservations.factories.ReservationsFactory;
import dat3.car.members.MembersDbInitializor;
import dat3.car.cars.repositories.ICarRepository;
import dat3.car.members.repositories.IMemberRepository;
import dat3.car.repository.IReservationRepository;
import dat3.car.reservations.services.CarReservation;
import dat3.car.shared.services.Http.HttpJsonResult;
import dat3.car.reservations.services.CarReservationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collections;
import java.util.List;

@DataJpaTest
public class ReservationsTestServices {
    public void initDatabases(){
        _carsInitializor.init(_cars);
        _membersInitializor.init(_members);
    }

    protected void clearDatabases(){
        _carsInitializor.clear(_cars);
        _membersInitializor.clear(_members);
    }

    protected CarReservationManager manager(){
        var reservation = new CarReservation(_reservations,_factory, _cars, _members);
        return new CarReservationManager(reservation,new HttpJsonResult(),_factory, _reservations);
    }

    protected Reservation randomRerservation(){
        List<Reservation> reservations = _reservations.findAll();
        Collections.shuffle(reservations);
        return reservations.stream().findFirst().orElse(null);
    }

    protected final CarsDbInitializor _carsInitializor = new CarsDbInitializor();
    protected final MembersDbInitializor _membersInitializor = new MembersDbInitializor();
    protected final ReservationsFactory _factory = new ReservationsFactory();


    @Autowired
    protected IReservationRepository _reservations;
    @Autowired
    protected ICarRepository _cars;
    @Autowired
    protected IMemberRepository _members;
}
