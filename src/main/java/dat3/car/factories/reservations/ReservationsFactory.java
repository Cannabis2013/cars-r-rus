package dat3.car.factories.reservations;

import dat3.car.dto.reservations.ReservationRequest;
import dat3.car.dto.reservations.ReservationResponse;
import dat3.car.entities.cars.Car;
import dat3.car.entities.members.Member;
import dat3.car.entities.reservations.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationsFactory {
    public Reservation fromRequest(ReservationRequest request, Car car, Member member)
    {
        return Reservation.builder()
                .member(member)
                .start(request.getStart())
                .end(request.getEnd())
                .car(car)
                .build();
    }

    public ReservationResponse toResponse(Reservation reservation)
    {
        return ReservationResponse.builder()
                .reservationId(reservation.getId())
                .carId(reservation.getCar().getId())
                .brand(reservation.getCar().getBrand())
                .model(reservation.getCar().getModel())
                .start(reservation.getStart())
                .end(reservation.getEnd())
                .build();
    }
}
