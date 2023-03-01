package dat3.car.entities.cars;

import dat3.car.entities.base.EntityModel;
import dat3.car.entities.reservations.Reservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@AllArgsConstructor
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

    private String description;
    private int year;
    private String color;

    @Column
    private String imageFilePath = "";

    @ElementCollection
    private Map<String,String> features = new HashMap<>();

    @ElementCollection
    private List<String> recommendations = new ArrayList<>();

    @OneToMany(
            mappedBy = "car",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Reservation> reservations = new ArrayList<>();

    @Column(name = "max_discount")
    private int bestDiscount;
}
