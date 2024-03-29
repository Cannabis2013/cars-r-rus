package dat3.car.cars.repositories;

import dat3.car.cars.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ICarRepository extends JpaRepository<Car,String> {
    @Transactional
    @Modifying
    @Query("update Car c set c.brand = ?1, c.model = ?2 where c.id like ?3")
    int updateCarDetails(String brand, String model, String id);
    Optional<Car> findByBrandLikeAndModelLike(String brand, String model);

}
