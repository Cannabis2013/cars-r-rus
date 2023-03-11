package dat3.car.config.dbInit.cars.VW;

import dat3.car.entities.cars.Car;

public class VWID4{
    public VWID4() {
        _car = new Car();
        updateBasicDetails();
        updateFeatures();
        _car.setImageFilePath("src/main/java/dat3/car/config/dbInit/cars/VW/vw_id4.jpg");
        _car.setPricePrDay(4500);
        _car.setDescription("""
                Volkswagens popular electric vehicle.
                """);

    }

    public Car getCar() {
        return _car;
    }

    private void updateBasicDetails(){
        _car.setBrand("Volkswagen");
        _car.setModel("ID.4");
        _car.setProductionYear(2021);
        _car.setColor("black");
    }

    private void updateFeatures(){
        _car.getFeatures().put("Chernobog Transparency",
                """
                        A broken front window and missing left rear window provides
                        excellent A/C at no fuel consumption cost. Great at summer season,
                        not so much at winter.
                        """);
        _car.getFeatures().put("Road Condition Feature",
                """
                        Two massive holes in the floor located at the back section
                        enables a great opportunity to asses the road quality from inside
                        the car while driving.
                        """);
    }

    private Car _car;
}
