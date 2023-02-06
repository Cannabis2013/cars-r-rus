package dat3.car.dto.cars;

import lombok.Getter;

@Getter
public final class CarRequest {
    public CarRequest(String brand, String model, String carId) {
        this.brand = brand;
        this.model = model;
        this.carId = carId;
    }

    public CarRequest(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void setPricePrDay(double pricePrDay) {
        this.pricePrDay = pricePrDay;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    private final String brand;
    private final String model;
    private double pricePrDay;
    private String carId;
}
