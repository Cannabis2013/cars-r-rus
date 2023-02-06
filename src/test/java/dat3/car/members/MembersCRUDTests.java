package dat3.car.members;

import dat3.car.dto.members.MemberRequest;
import dat3.car.services.members.Members;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MembersCRUDTests {
    @Test
    public void addMemberToDatabase(){

        var request = defaultRequest();
        var response = members.add(request);
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }

    private MemberRequest defaultRequest()
    {
        var request = MemberRequest.builder()
                .username("Willamok").email("willerex@gmail.com")
                .password("PikErGud")
                .firstName("William").lastName("Adelkilde")
                .street("Holmbladsparken 17B").city("Sundby").zip("2300S")
                .phones(new HashMap<>(){
                    {
                        put("Home","23232323");
                        put("Work","24242424");
                    }
                }).build();
        return request;
    }

    @Autowired
    private Members members;
}
