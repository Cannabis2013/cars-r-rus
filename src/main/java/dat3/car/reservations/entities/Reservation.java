package dat3.car.reservations.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat3.car.shared.entities.EntityModel;
import dat3.car.cars.entities.Car;
import dat3.car.members.entities.Member;
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
