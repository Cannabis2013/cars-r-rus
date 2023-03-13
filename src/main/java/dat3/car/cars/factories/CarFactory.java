package dat3.car.cars.factories;

import dat3.car.cars.dtos.CarFetchResponse;
import dat3.car.cars.dtos.CarsAddRequest;
import dat3.car.cars.entities.Car;
import org.springframework.stereotype.Service;

@Service
public class CarFactory implements ICarFactory {
    public CarFactory(IImageConverter<String> imageConverter) {
        _imageConverter = imageConverter;
    }

    @Override
    public Car fromAddRequest(CarsAddRequest request){
        return new Car(request.getBrand(),request.getModel(),request.getPricePrDay());
    }

    @Override
    public CarFetchResponse toResponse(Car car){
        return CarFetchResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getProductionYear())
                .pricePrDay(car.getPricePrDay())
                .features(car.getFeatures())
                .description(car.getDescription())
                .recommendations(car.getRecommendations())
                .imageBinary(_imageConverter.convert(car.getImageFilePath()))
                .build();
    }

    private final IImageConverter<String> _imageConverter;
}
