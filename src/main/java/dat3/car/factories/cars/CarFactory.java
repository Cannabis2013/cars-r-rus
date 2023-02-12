package dat3.car.factories.cars;

import dat3.car.Entities.cars.CarRestricted;
import dat3.car.Entities.cars.CarUnrestricted;
import org.springframework.stereotype.Service;

@Service
public class CarFactory {
    public CarUnrestricted toUnrestricted(CarRestricted car){
        var unrestricted = new CarUnrestricted();
        unrestricted.setId(car.getId());
        unrestricted.setPricePrDay(car.getPricePrDay());
        unrestricted.setBrand(car.getBrand());
        unrestricted.setModel(car.getModel());
        return unrestricted;
    }
}
