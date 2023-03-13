package dat3.car.cars.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarsAddRequest {
    private String brand;
    private String model;
    private double pricePrDay;
    private int bestDiscount;
}
