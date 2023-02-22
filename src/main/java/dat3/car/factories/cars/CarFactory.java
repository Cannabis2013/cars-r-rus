package dat3.car.factories.cars;

import dat3.car.contracts.cars.ICarFactory;
import dat3.car.dto.cars.CarResponse;
import dat3.car.dto.cars.CarsAddRequest;
import dat3.car.entities.cars.Car;
import org.springframework.stereotype.Service;

@Service
public class CarFactory implements ICarFactory {
    @Override
    public Car fromAddRequest(CarsAddRequest request){
        return new Car(request.getBrand(),request.getModel(),request.getPricePrDay());
    }

    @Override
    public CarResponse toResponse(Car car){
        return new CarResponse(car.getId(),car.getBrand(),car.getModel(),car.getPricePrDay());
    }
}
