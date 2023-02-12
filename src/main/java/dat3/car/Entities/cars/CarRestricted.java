package dat3.car.Entities.cars;

import dat3.car.Entities.EntityModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
