package dat3.car.config.dbInit.cars.Fiat;

import dat3.car.cars.entities.Car;

public class Duna70 {
    public Duna70() {
        _car = new Car();
        _car.setBrand("Fiat");
        _car.setModel("Duna 70");
        _car.setImageFilePath("duna70.png");
        _car.setColor("white");
        _car.setProductionYear(1985);
        _car.setDescription("""
                An italian made car with a good engine and bad exhausting system. 
                I think the one makes up for the other part, we guess.
                """);
        _car.getFeatures().put("Safety first","All airbags intact");
        _car.setPricePrDay(1250);
        _car.getRecommendations().add("Chernobogs Precationary Select");
        _car.setImageFilePath("src/main/resources/static/duna70.png");
    }

    public Car getCar() {
        return _car;
    }

    private Car _car;
}
