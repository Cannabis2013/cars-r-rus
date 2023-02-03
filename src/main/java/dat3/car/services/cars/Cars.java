package dat3.car.services.cars;

import dat3.car.Entities.cars.Car;
import dat3.car.SLA.Http.HttpResult;
import dat3.car.dto.cars.CarDto;
import dat3.car.factories.cars.CarFactory;
import dat3.car.repository.CarRepository;
import dat3.car.services.Entities.EntitiesConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class Cars {
    public Cars(HttpResult<String> response, CarRepository carRepository, CarFactory factory) {
        _factory = factory;
        _converter = new EntitiesConverter<>();
        _response = response;
        _carRepository = carRepository;
    }

    public ResponseEntity<String> all()
    {
        var ite = _carRepository.findAll();
        var cars = _converter.toList(ite);
        var carDtos = cars.stream().map(_factory::toDto).toList();
        return _response.ok(carDtos);
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
        return _response.ok(_factory.toDto(car));
    }

    public ResponseEntity<String> add(CarDto dto)
    {
        var car = _factory.fromDto(dto);
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
            return _response.bad(e.getMessage());
        }
        return _response.ok();
    }

    private final EntitiesConverter<Car> _converter;
    private final HttpResult<String> _response;
    private final CarRepository _carRepository;
    private final CarFactory _factory;
}
