package dat3.car.reservations.factories;

import dat3.car.reservations.dtos.ReservationRequest;
import dat3.car.reservations.dtos.ReservationResponse;
import dat3.car.cars.entities.Car;
import dat3.car.members.entities.Member;
import dat3.car.reservations.entities.Reservation;
import org.springframework.stereotype.Service;

@Service
public class ReservationsFactory {
    public Reservation fromRequest(ReservationRequest request, Car car, Member member)
    {
        return Reservation.builder()
                .member(member)
                .reservationStart(request.getReservationStart())
                .reservationEnd(request.getReservationEnd())
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
                .reservationStart(reservation.getReservationStart())
                .reservationEnd(reservation.getReservationEnd())
                .build();
    }
}