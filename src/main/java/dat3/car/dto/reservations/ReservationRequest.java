package dat3.car.dto.reservations;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ReservationRequest(String carId,
                                 String memberId,
                                 LocalDate start,
                                 LocalDate end) {

}
