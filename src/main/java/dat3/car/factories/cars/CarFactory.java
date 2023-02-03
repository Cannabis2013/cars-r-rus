package dat3.car.factories.cars;

import dat3.car.Entities.cars.Car;
import dat3.car.dto.cars.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarFactory {
    public CarFactory() {}

    public List<Car> build(){
        var assembler = new CarListAssembler();
        return assembler.cars();
    }

    public Car build(String brand, String model, double pricePrDay)
    {
        var car = new Car(brand,model,pricePrDay);
        return car;
    }

    public Car fromDto(CarDto dto){
        var car = new Car(dto.getBrand(),dto.model(),dto.getPricePrDay());
        var bestDiscount = (int) (car.getPricePrDay() *0.85);
        car.setBestDiscount(bestDiscount);
        return car;
    }

    public CarDto toDto(Car car)
    {
        return new CarDto(car.getBrand(),car.getModel(),car.getPricePrDay());
    }
}
