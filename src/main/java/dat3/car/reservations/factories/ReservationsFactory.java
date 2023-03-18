package dat3.car.reservations.factories;

import dat3.car.members.repositories.IMemberRepository;
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
                .memberId(member.getId())
                .reservationStart(request.getReservationStart())
                .reservationEnd(request.getReservationEnd())
                .car(car)
                .build();
    }

    public ReservationResponse toResponse(Reservation reservation, Member member)
    {
        return response(reservation,member);
    }

    private ReservationResponse response(Reservation reservation, Member member){
        return ReservationResponse.builder()
                .reservationId(reservation.getId())
                .carId(reservation.getCar().getId())
                .brand(reservation.getCar().getBrand())
                .memberName(member.getUsername())
                .model(reservation.getCar().getModel())
                .reservationStart(reservation.getReservationStart())
                .reservationEnd(reservation.getReservationEnd())
                .build();
    }
}
