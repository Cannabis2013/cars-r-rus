package dat3.car.Entities.reservations;

import dat3.car.Entities.EntityModel;
import dat3.car.Entities.cars.CarUnrestricted;
import dat3.car.Entities.members.MemberUnrestricted;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation extends EntityModel {
    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setCar(CarUnrestricted car) {
        this.car = car;
    }

    private LocalDateTime start;
    private LocalDateTime end;

    @ManyToOne
    private CarUnrestricted car;

    private String memberId;
}
