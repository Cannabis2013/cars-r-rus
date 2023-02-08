package dat3.car.Entities.cars;

import dat3.car.Entities.EntityModel;
import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car extends EntityModel {
    public Car(String brand, String model, double pricePrDay) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPricePrDay() {
        return pricePrDay;
    }

    public void setPricePrDay(double pricePrDay) {
        this.pricePrDay = pricePrDay;
    }

    public int getBestDiscount() {
        return bestDiscount;
    }

    public void setBestDiscount(int bestDiscount) {
        this.bestDiscount = bestDiscount;
    }

    @Column(name = "car_brand",length = 50,nullable = false, columnDefinition = "varchar(50) default 'brand'")
    protected String brand;

    @Column(name = "car_model",length = 50,nullable = false, columnDefinition = "varchar(50) default 'model'")
    protected String model;

    @Column(name = "rental_price_day")
    protected double pricePrDay;

    @Column(name = "max_discount")
    private int bestDiscount;
}
