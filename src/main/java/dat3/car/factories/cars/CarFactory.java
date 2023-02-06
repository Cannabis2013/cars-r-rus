package dat3.car.factories.cars;

import dat3.car.Entities.cars.Car;
import dat3.car.dto.cars.CarRequest;
import dat3.car.dto.cars.CarResponse;
import org.springframework.stereotype.Service;

@Service
public class CarFactory {
    public CarFactory() {}

    public Car car(String brand, String model, double pricePrDay)
    {
        return new Car(brand,model,pricePrDay);
    }

    public Car fromRequest(CarRequest dto){
        var car = new Car(dto.getBrand(),dto.model(),dto.getPricePrDay());
        var bestDiscount = (int) (car.getPricePrDay() *0.85);
        car.setBestDiscount(bestDiscount);
        return car;
    }

    public CarResponse toResponse(Car car)
    {
        return new CarResponse(car.getBrand(),car.getModel(),car.getPricePrDay());
    }
}
