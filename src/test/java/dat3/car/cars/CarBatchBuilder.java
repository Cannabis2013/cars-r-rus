package dat3.car.cars;

import dat3.car.dto.cars.CarRequest;
import org.springframework.stereotype.Service;

@Service
public class CarBatchBuilder {
    CarRequest request(){
        return new CarRequest("Tesla ","Modex X");
    }
}
