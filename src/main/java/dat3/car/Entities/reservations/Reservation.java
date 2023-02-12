package dat3.car.Entities.reservations;

import dat3.car.Entities.EntityModel;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Reservation extends EntityModel {

    LocalDateTime start;
    LocalDateTime end;
}
