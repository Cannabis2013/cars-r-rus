package dat3.car.reservations.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public final class ReservationRequest {
    private String carId;
    private String memberName;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
}
