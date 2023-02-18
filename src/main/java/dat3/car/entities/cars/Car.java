package dat3.car.entities.cars;

import dat3.car.entities.base.EntityModel;
import dat3.car.entities.reservations.Reservation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "car")
public class Car extends EntityModel {
    public Car(String brand, String model, double pricePrDay) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
    }

    @Column(name = "car_brand",length = 50,nullable = false, columnDefinition = "varchar(50) default 'brand'")
    private String brand;
    @Column(name = "car_model",length = 50,nullable = false, columnDefinition = "varchar(50) default 'model'")
    private String model;
    @Column(name = "rental_price_day")
    private double pricePrDay;

    @OneToMany(
            mappedBy = "car",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Reservation> reservations = new ArrayList<>();

    @Column(name = "max_discount")
    private int bestDiscount;
}
