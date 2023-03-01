package dat3.car.config.dbInit.cars.Nissan;

import dat3.car.contracts.Utils.IImageConverter;
import dat3.car.entities.cars.Car;

public class NissanShitbox {
    public NissanShitbox() {
        _car = new Car();
        _car.setBrand("Nissan");
        _car.setModel("Shitbox");
        _car.setColor("white");
        _car.setYear(1983);
        _car.setDescription("""
                Allright, this is not one of the popular choices. With nearly everything broken
                this car is not for the faint of hearth. But it comes with a low price.
                """);
        _car.getFeatures().put("Missing tires",
                "One tire is missing. Please provide one yourself");
        _car.getFeatures().put("Chernobog Transparency",
                "It comes with full A/C with all windows broken, but with no fuel consumption");
        _car.getFeatures().put("Chernobogs Engine Dismantle","Engine is dismantled and is located in the trunk");
        _car.getFeatures().put("Chernobog Raw Metal Look","Nothing but bare metal interior design");
        _car.setPricePrDay(300);
        _car.setImageFilePath("/home/mh/GitRepos/cars_backend/src/main/java/dat3/car/config/dbInit/cars/Nissan/nissan_shitbox_1983.png");
    }

    public Car getCar() {
        return _car;
    }

    private Car _car;
}
