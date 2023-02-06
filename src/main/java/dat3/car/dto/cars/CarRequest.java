package dat3.car.dto.cars;

public final class CarRequest {
    public CarRequest(String brand, String model, double pricePrDay) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
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
}
