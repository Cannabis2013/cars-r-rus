package dat3.car.cars.factories;

import dat3.car.cars.dtos.CarFetchResponse;
import dat3.car.cars.dtos.CarsAddRequest;
import dat3.car.cars.entities.Car;

public interface ICarFactory {
    Car fromAddRequest(CarsAddRequest request);

    CarFetchResponse toResponse(Car car);
}
