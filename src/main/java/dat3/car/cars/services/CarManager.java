package dat3.car.cars.services;

import dat3.car.shared.services.Http.IHttpResult;
import dat3.car.cars.factories.ICarFactory;
import dat3.car.cars.dtos.CarUpdateRequest;
import dat3.car.cars.dtos.CarsAddRequest;
import dat3.car.cars.repositories.ICarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarManager {
    public CarManager(IHttpResult<String> response, ICarRepository carRepository, ICarFactory factory) {
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
        var optional = _carRepository.findById(id);
        if(optional.isEmpty())
            return _response.notFound();
        var car =  _factory.toResponse(optional.get());
        return _response.ok(car);
    }

    public ResponseEntity<String> add(CarsAddRequest restricted)
    {
        var unrestricted = _factory.fromAddRequest(restricted);
        try {
            _carRepository.save(unrestricted);
        } catch (Exception e){
            return _response.badRequest(e.getMessage());
        }
        return _response.created(unrestricted);
    }

    public ResponseEntity<String> remove(String id){
        var car = _carRepository.findById(id).orElse(null);
        if(car == null)
            return _response.notFound();
        try {
            _carRepository.delete(car);
        } catch (Exception e){
            return _response.badRequest("Failed to remove resource");
        }
        return _response.ok();
    }

    public ResponseEntity<String> update(CarUpdateRequest request)
    {
        try {
            _carRepository.updateCarDetails(request.getBrand(),request.getModel(),request.getId());
        }catch (Exception e){
            return _response.badRequest("Failed to update resource");
        }
        return _response.ok();
    }

    private final IHttpResult<String> _response;
    private final ICarRepository _carRepository;
    private final ICarFactory _factory;
}
