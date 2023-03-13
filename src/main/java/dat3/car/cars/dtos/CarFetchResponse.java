package dat3.car.cars.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Builder
@Getter
public class CarFetchResponse {
    private String id;
    private String brand;
    private String model;
    private int year;
    private String imageBinary;
    private double pricePrDay;
    private Map<String,String> features;
    private List<String> recommendations;
    private String description;
}
