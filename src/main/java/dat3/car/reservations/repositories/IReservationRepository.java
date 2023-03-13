package dat3.car.reservations.repositories;

import dat3.car.reservations.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<Reservation,String> {
}
