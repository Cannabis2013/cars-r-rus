package dat3.car.contracts.cars;

import dat3.car.dto.cars.CarFetchResponse;
import dat3.car.dto.cars.CarsAddRequest;
import dat3.car.entities.cars.Car;

public interface ICarFactory {
    Car fromAddRequest(CarsAddRequest request);

    CarFetchResponse toResponse(Car car);
}
