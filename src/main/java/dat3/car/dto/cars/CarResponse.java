package dat3.car.dto.cars;

public final class CarResponse {
    public CarResponse(String brand, String model, double pricePrDay, String carId) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public String model() {
        return model;
    }

    public double getPricePrDay() {
        return pricePrDay;
    }

    private final String brand;
    private final String model;
    private final double pricePrDay;
    private final String carId;
}
