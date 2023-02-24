package dat3.car.repository;

import dat3.car.entities.reservations.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<Reservation,String> {
}
