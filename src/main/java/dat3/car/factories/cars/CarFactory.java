package dat3.car.factories.cars;

import dat3.car.contracts.Utils.IImageConverter;
import dat3.car.contracts.cars.ICarFactory;
import dat3.car.dto.cars.CarFetchResponse;
import dat3.car.dto.cars.CarsAddRequest;
import dat3.car.entities.cars.Car;
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
