package dat3.car.Entities.reservations;

import dat3.car.Entities.base.EntityModel;
import dat3.car.Entities.cars.CarUnrestricted;
import dat3.car.Entities.members.MemberUnrestricted;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Reservation extends EntityModel {

    private LocalDateTime start;
    private LocalDateTime end;

    @ManyToOne
    private CarUnrestricted car;

    @ManyToOne
    private MemberUnrestricted memberId;
}
