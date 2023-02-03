package dat3.car;

import dat3.car.ConsoleIO.CarsConsoleApiInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarsApplication.class, args);
        CarsConsoleApiInfo.print();
    }

}
