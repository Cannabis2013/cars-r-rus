package dat3.car.reservations;

import dat3.car.cars.CarsDbInitializor;
import dat3.car.entities.reservations.Reservation;
import dat3.car.factories.reservations.ReservationsFactory;
import dat3.car.members.MembersDbInitializor;
import dat3.car.repository.ICarRepository;
import dat3.car.repository.IMemberRepository;
import dat3.car.repository.IReservationRepository;
import dat3.car.services.Http.HttpJsonResult;
import dat3.car.services.reservations.CarReservationManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class ReservationsTestServices {
    protected void initDatabases(){
        _carsInitializor.init(_cars);
        _membersInitializor.init(_members);
    }

    protected void clearDatabases(){
        _carsInitializor.clear(_cars);
        _membersInitializor.clear(_members);
    }

    protected CarReservationManager manager(){
        var reservation = new dat3.car.services.reservations.CarReservation(_reservations,_factory, _cars, _members);
        return new CarReservationManager(reservation,new HttpJsonResult(),_factory, _reservations);
    }

    protected Reservation randomRerservation(){
        List<Reservation> reservations;
        try{
            reservations = _reservations.findAll();
        } catch (Exception e){
            throw e;
        }
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
