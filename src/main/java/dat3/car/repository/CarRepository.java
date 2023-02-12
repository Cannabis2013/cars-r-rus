package dat3.car.repository;

import dat3.car.Entities.cars.CarUnrestricted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CarRepository extends JpaRepository<CarUnrestricted,String> {
    @Transactional
    @Modifying
    @Query("update CarUnrestricted c set c.brand = ?1, c.model = ?2 where c.id like ?3")
    int updateCarDetails(String brand, String model, String id);
    CarUnrestricted findByBrandLikeAndModelLike(String brand, String model);

}
