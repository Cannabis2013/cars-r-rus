package dat3.car.members;

import dat3.car.dto.members.MemberRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberRequestBuilder {
    public MemberRequest defaultRequest()
    {
        return defaultRequest();
    }

    private MemberRequest request(){
        var firstName = "William";
        var lastName = "Adelkilde";
        var username = "WillAmok";
        var email = "willerex@gmail.com";
        var request = MemberRequest.builder()
                .username(username).email(email)
                .password("PikErGud")
                .firstName(firstName).lastName(lastName)
                .street("Holmbladsparken 17B").city("Sundby").zip("2300S")
                .phones(phones()).build();
        return request;
    }

    private Map<String,String> phones(){
        return new HashMap<>() {
            {
                put("Home", "111-222-333");
                put("Work", "666-666-666");
            }
        };
    }
}
