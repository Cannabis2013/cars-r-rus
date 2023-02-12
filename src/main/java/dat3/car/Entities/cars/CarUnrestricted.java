package dat3.car.Entities.cars;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "car")
public class CarUnrestricted extends CarRestricted {
    public CarUnrestricted(String brand, String model, double pricePrDay) {
        super(brand, model, pricePrDay);
    }

    public int getBestDiscount() {
        return bestDiscount;
    }

    public void setBestDiscount(int bestDiscount) {
        this.bestDiscount = bestDiscount;
    }

    @Column(name = "max_discount")
    private int bestDiscount;
}
