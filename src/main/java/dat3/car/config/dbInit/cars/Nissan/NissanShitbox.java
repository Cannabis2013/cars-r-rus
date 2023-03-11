package dat3.car.config.dbInit.cars.Nissan;

import dat3.car.entities.cars.Car;

public class NissanShitbox {
    public NissanShitbox() {
        _car = new Car();
        updateBasicDetails();
        _car.setDescription("""
                Allright, this is not one of the popular choices. With nearly everything broken
                this car is not for the faint of hearth. But it comes with a low price.
                """);
        updateFeatures();
        _car.setImageFilePath("src/main/java/dat3/car/config/dbInit/cars/Nissan/nissan_shitbox_1983.png");
    }

    public Car getCar() {
        return _car;
    }

    private void updateBasicDetails() {
        _car.setBrand("Nissan");
        _car.setModel("Shitbox");
        _car.setColor("white");
        _car.setProductionYear(1983);
        _car.setPricePrDay(300);
    }

    private void updateFeatures(){
        _car.getFeatures().put("Missing tires",
                "One tire is missing. Please provide one yourself");
        _car.getFeatures().put("Chernobog Transparency",
                "It comes with full A/C with all windows broken, but with no fuel consumption");
        _car.getFeatures().put("Chernobogs Engine Dismantle","Engine is dismantled and is located in the trunk");
        _car.getFeatures().put("Chernobog Raw Metal Look","Nothing but bare metal interior design");
    }

    private Car _car;
}
