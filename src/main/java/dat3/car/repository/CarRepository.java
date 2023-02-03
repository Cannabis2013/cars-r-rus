package dat3.car.repository;

import dat3.car.Entities.cars.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car,String> {
    Car findByBrandLikeAndModelLike(String _brand, String _model);
}
