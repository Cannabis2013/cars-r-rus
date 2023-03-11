package dat3.car.config.dbInit.cars.Ford;

import dat3.car.entities.cars.Car;

public class FordRS2000 {
    public FordRS2000() {
        _car = new Car();
        _car.setBrand("Ford");
        _car.setModel("Escort RS2000");
        _car.setColor("white");
        _car.setProductionYear(1997);
        _car.setDescription("""
                A rally car which makes it an ideal choice to those who wants
                to go offroad in the local forest. With lot of horsepowers and
                fancy looking front lights, this is not a boring choice.
                """);
        _car.getFeatures().put("Missing tires",
                "One tire is missing. Please provide one yourself");
        _car.setPricePrDay(3500);
        _car.getRecommendations().add("Chernobogs pick 2023");
        _car.setImageFilePath("/home/mh/GitRepos/cars_backend/src/main/java/dat3/car/config/dbInit/cars/Ford/Ford_Escort_RS2000.webp");
    }

    public Car getCar() {
        return _car;
    }

    private Car _car;
}
