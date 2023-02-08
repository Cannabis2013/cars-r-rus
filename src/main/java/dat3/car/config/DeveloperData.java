package dat3.car.config;
/*
import dat3.car.factories.cars.CarFactory;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

public class DeveloperData implements ApplicationRunner {
    public DeveloperData(MemberBatchFactory memberFactory, CarRepository carRepository, MemberRepository memberRepository, CarBatchFactory carFactory) {
        this.memberFactory = memberFactory;
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
        this.carFactory = carFactory;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initDatabase();
    }

    private void initDatabase()
    {
        var cars = carFactory.cars();
        var members = memberFactory.build();
        try {
            carRepository.saveAll(cars);
            memberRepository.saveAll(members);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private final MemberBatchFactory memberFactory;
    private final MemberRepository memberRepository;
    private final CarRepository carRepository;
    private final CarBatchFactory carFactory;
}
 */
