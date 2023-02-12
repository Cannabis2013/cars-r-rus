package dat3.car.cars;


import dat3.car.Entities.cars.CarRestricted;
import org.springframework.stereotype.Service;

@Service
public class CarBatchBuilder {
    CarRestricted teslaModelX(){
        return new CarRestricted("Tesla ","Modex X",25);
    }
}
