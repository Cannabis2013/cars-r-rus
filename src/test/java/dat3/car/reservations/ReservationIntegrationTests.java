package dat3.car.reservations;

import dat3.car.dto.reservations.ReservationRequest;
import dat3.car.services.reservations.CarReservationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DataJpaTest
public class ReservationIntegrationTests extends ReservationsTestServices {
    @BeforeEach
    public void init(){
        _reservationsManager = manager();
        initDatabases();
    }

    @AfterEach
    public void clear(){
        clearDatabases();
    }

    @Test
    public void addReservation() {
        var car = _carsInitializor.randomCar(_carRepository);
        var member = _membersInitializor.randomMember(_memberRepository);
        var start = LocalDateTime.now();
        var end = start.plusDays(5);
        var res = new ReservationRequest(car.getId(),member.getId(),start,end);
        var response = _reservationsManager.reserve(res);
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }

    private CarReservationManager _reservationsManager;
}
