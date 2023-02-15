package dat3.car.Entities.cars;

import dat3.car.Entities.base.EntityModel;
import dat3.car.Entities.reservations.Reservation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public class CarRestricted extends EntityModel {
    public CarRestricted(String brand, String model, double pricePrDay) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
    }

    @Column(name = "car_brand",length = 50,nullable = false, columnDefinition = "varchar(50) default 'brand'")
    protected String brand;
    @Column(name = "car_model",length = 50,nullable = false, columnDefinition = "varchar(50) default 'model'")
    protected String model;
    @Column(name = "rental_price_day")
    protected double pricePrDay;
    @OneToMany(
            mappedBy = "car",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true
    )
    protected List<Reservation> reservations = new ArrayList<>();
}
