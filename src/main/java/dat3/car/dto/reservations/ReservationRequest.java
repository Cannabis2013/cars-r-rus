package dat3.car.dto.reservations;

import java.time.LocalDateTime;

public record ReservationRequest(String carId,
                                 String memberId,
                                 LocalDateTime start,
                                 LocalDateTime end) {

}
