package dat3.car.repository;

import dat3.car.Entities.cars.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CarRepository extends JpaRepository<Car,String> {
    @Transactional
    @Modifying
    @Query("update Car c set c.brand = ?1, c.model = ?2 where c.id like ?3")
    int updateCarDetails(String brand, String model, String id);
    Car findByBrandLikeAndModelLike(String brand, String model);

}
