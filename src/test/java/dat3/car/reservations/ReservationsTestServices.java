package dat3.car.reservations;

import dat3.car.cars.CarsDbInitializor;
import dat3.car.factories.reservations.ReservationsFactory;
import dat3.car.members.MembersDbInitializor;
import dat3.car.repository.ICarRepository;
import dat3.car.repository.IMemberRepository;
import dat3.car.repository.IReservationRepository;
import dat3.car.services.Http.HttpJsonResult;
import dat3.car.services.reservations.CarReservation;
import dat3.car.services.reservations.CarReservationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ReservationsTestServices {
    protected void initDatabases(){
        _carsInitializor.init(_carRepository);
        _membersInitializor.init(_memberRepository);
    }

    protected void clearDatabases(){
        _carsInitializor.clear(_carRepository);
        _membersInitializor.clear(_memberRepository);
    }

    protected CarReservationManager manager(){
        var reservation = new CarReservation(_repository,_factory,_carRepository,_memberRepository);
        return new CarReservationManager(reservation,new HttpJsonResult(),_factory,_repository);
    }

    protected final CarsDbInitializor _carsInitializor = new CarsDbInitializor();
    protected final MembersDbInitializor _membersInitializor = new MembersDbInitializor();
    protected final ReservationsFactory _factory = new ReservationsFactory();


    @Autowired
    protected IReservationRepository _repository;
    @Autowired
    protected ICarRepository _carRepository;
    @Autowired
    protected IMemberRepository _memberRepository;
}
