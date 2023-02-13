package dat3.car.services.cars;

import dat3.car.Entities.cars.CarRestricted;
import dat3.car.SLA.Http.IHttpResult;
import dat3.car.factories.cars.CarFactory;
import dat3.car.repository.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Cars {
    public Cars(IHttpResult<String> response, CarRepository carRepository, CarFactory factory) {
        _factory = factory;
        _response = response;
        _carRepository = carRepository;
    }

    public ResponseEntity<String> all()
    {
        var cars = _carRepository.findAll();
        var response = cars.stream().map(c -> (CarRestricted) c).toList();
        return _response.ok(response);
    }

    public ResponseEntity<String> get(String id)
    {
        var optional = _carRepository.findById(id);
        if(optional.isEmpty())
            return _response.notFound();
        var car = (CarRestricted) optional.get();
        return _response.ok(car);
    }

    public ResponseEntity<String> add(CarRestricted restricted)
    {
        var unrestricted = _factory.toUnrestricted(restricted);
        try {
            _carRepository.save(unrestricted);
        } catch (Exception e){
            return _response.badRequest(e.getMessage());
        }
        return _response.created(unrestricted);
    }

    public ResponseEntity<String> remove(String id){
        if(!_carRepository.existsById(id))
            return _response.notFound();
        try {
            _carRepository.deleteById(id);
        } catch (Exception e){
            return _response.badRequest("Failed to remove resource");
        }
        return _response.ok();
    }

    public ResponseEntity<String> update(CarRestricted request)
    {
        try {
            _carRepository.updateCarDetails(request.getBrand(),request.getModel(),request.getId());
        }catch (Exception e){
            return _response.badRequest("Failed to update resource");
        }
        return _response.ok();
    }

    private final IHttpResult<String> _response;
    private final CarRepository _carRepository;
    private final CarFactory _factory;
}
