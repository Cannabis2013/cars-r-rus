package dat3.car.config.dbInit.cars.VW;

import dat3.car.contracts.Utils.IImageConverter;
import dat3.car.entities.cars.Car;

public class VWID4{
    public VWID4() {
        _car = new Car();
        _car.setBrand("Volkswagen");
        _car.setModel("ID.4");
        _car.setYear(2021);
        _car.setColor("black");
        _car.setDescription("""
                Volkswagens popular electric vehicle.
                """);
        _car.getFeatures().put("Chernobog Transparency",
                "A broken front window and missing left rear window");
        _car.getFeatures().put("Road Condition Feature",
                "To massive holes in the floor located at the back section");
        _car.setPricePrDay(4500);
        _car.setImageFilePath("/home/mh/GitRepos/cars_backend/src/main/java/dat3/car/config/dbInit/cars/VW/vw_id4.jpg");

    }

    public Car getCar() {
        return _car;
    }

    private Car _car;
}
