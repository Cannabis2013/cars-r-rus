package dat3.car.config.dbInit.cars;

import dat3.car.config.dbInit.cars.Fiat.Duna70;
import dat3.car.config.dbInit.cars.Ford.FordRS2000;
import dat3.car.config.dbInit.cars.Lada.Lada500Classic;
import dat3.car.config.dbInit.cars.Nissan.NissanShitbox;
import dat3.car.config.dbInit.cars.VW.VWID4;
import dat3.car.entities.cars.Car;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarBatchFactory {
    public List<Car> batch()
    {
        return new ArrayList<Car>() {
            {
                add(new VWID4().getCar());
                add(new FordRS2000().getCar());
                add(new NissanShitbox().getCar());
                add(new Lada500Classic().getCar());
                add(new Duna70().getCar());
            }
        };
    }
}
