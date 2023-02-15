package dat3.car.entities.reservations;

import dat3.car.entities.base.EntityModel;
import dat3.car.entities.cars.Car;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Reservation extends EntityModel {

    private LocalDate start;
    private LocalDate end;

    @ManyToOne
    private Car car;

    private String memberId;
}
