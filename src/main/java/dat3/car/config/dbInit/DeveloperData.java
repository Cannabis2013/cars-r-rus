package dat3.car.config.dbInit;

import dat3.car.config.dbInit.cars.CarBatchFactory;
import dat3.car.config.dbInit.members.MemberBatchFactory;
import dat3.car.cars.repositories.ICarRepository;
import dat3.car.members.repositories.IMemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeveloperData implements ApplicationRunner {
    public DeveloperData(MemberBatchFactory memberFactory, ICarRepository carRepository, IMemberRepository memberRepository, CarBatchFactory carFactory) {
        _memberFactory = memberFactory;
        _carRepository = carRepository;
        _memberRepository = memberRepository;
        _carFactory = carFactory;
    }

    @Override
    public void run(ApplicationArguments args) {
        initDatabase();
    }

    private void initDatabase()
    {
        var cars = _carFactory.batch();
        var members = _memberFactory.batch();
        try {
            _carRepository.saveAll(cars);
            _memberRepository.saveAll(members);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private final MemberBatchFactory _memberFactory;
    private final IMemberRepository _memberRepository;
    private final ICarRepository _carRepository;
    private final CarBatchFactory _carFactory;

}

