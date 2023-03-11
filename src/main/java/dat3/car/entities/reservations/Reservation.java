package dat3.car.entities.reservations;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat3.car.entities.base.EntityModel;
import dat3.car.entities.cars.Car;
import dat3.car.entities.members.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Reservation extends EntityModel {

    @JsonFormat(locale = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reservationStart;
    @JsonFormat(locale = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reservationEnd;

    @ManyToOne()
    @JoinColumn(name="car_id", nullable=false)
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="member_id", nullable=false)
    private Member member;
}
