package dat3.car.sla.cars;

import dat3.car.dto.cars.CarResponse;
import dat3.car.dto.cars.CarsAddRequest;
import dat3.car.entities.cars.Car;

public interface ICarFactory {
    Car fromAddRequest(CarsAddRequest request);

    CarResponse toResponse(Car car);
}
