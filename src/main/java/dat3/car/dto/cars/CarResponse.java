package dat3.car.dto.cars;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarResponse {
    private String id;
    private String brand;
    private String model;
    private double pricePrDay;
}
