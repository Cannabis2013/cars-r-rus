package dat3.car.config.dbInit.cars.Lada;

import dat3.car.entities.cars.Car;

public class Lada500Classic {
    public Lada500Classic() {
        _car = new Car();
        _car.setBrand("Lada");
        _car.setModel("500 Classic");
        _car.setProductionYear(1980);
        _car.setColor("lightblue");
        _car.setDescription("""
                Soviet made vehicle made up of old parts of russian T-39 tanks. A popular choice
                for a picnic or just a little nice ride out in the blue.
                """);
        _car.setPricePrDay(750);
        _car.setImageFilePath("src/main/java/dat3/car/config/dbInit/cars/Lada/lada_500_classic.jpg");
    }

    public Car getCar() {
        return _car;
    }

    private Car _car;
}
