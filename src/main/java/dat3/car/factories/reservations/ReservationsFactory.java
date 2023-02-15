package dat3.car.factories.reservations;

import dat3.car.entities.reservations.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ReservationsFactory {
    public Reservation reservation(LocalDate start, LocalDate end, String memberId)
    {
        return Reservation.builder().memberId(memberId)
                .start(start).end(end).build();
    }
}
