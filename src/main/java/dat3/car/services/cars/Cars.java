package dat3.car.services.cars;

import dat3.car.Entities.cars.Car;
import dat3.car.SLA.Http.HttpResult;
import dat3.car.dto.cars.CarRequest;
import dat3.car.factories.cars.CarFactory;
import dat3.car.repository.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class Cars {
    public Cars(HttpResult<String> response, CarRepository carRepository, CarFactory factory) {
        _factory = factory;
        _response = response;
        _carRepository = carRepository;
    }

    public ResponseEntity<String> all()
    {
        var cars = _carRepository.findAll();
        var response = cars.stream().map(_factory::toResponse).toList();
        return _response.ok(response);
    }

    public ResponseEntity<String> get(String id)
    {
        Optional<Car> optional;
        try {
            optional = _carRepository.findById(id);
        } catch (Exception e){
            return _response.bad(e.getMessage());
        }
        if(optional.isEmpty())
            return _response.notFound();
        var car = optional.get();
        return _response.ok(_factory.toResponse(car));
    }

    public ResponseEntity<String> add(CarRequest request)
    {
        var car = _factory.fromRequest(request);
        try {
            _carRepository.save(car);
        } catch (Exception e){
            return _response.bad(e.getMessage());
        }
        return _response.created(car);
    }

    public ResponseEntity<String> remove(String id){
        try {
            if(!_carRepository.existsById(id))
                return _response.notFound();
            _carRepository.deleteById(id);
        } catch (Exception e){
            return _response.bad("Failed to remove resource");
        }
        return _response.ok();
    }

    public ResponseEntity<String> update(CarRequest request)
    {
        Car car;
        try {
            _carRepository.updateCarDetails(request.getBrand(),request.getModel(),request.getCarId());
        }catch (Exception e){
            return _response.bad("Failed to update resource");
        }
        return _response.ok();
    }

    private final HttpResult<String> _response;
    private final CarRepository _carRepository;
    private final CarFactory _factory;
}
