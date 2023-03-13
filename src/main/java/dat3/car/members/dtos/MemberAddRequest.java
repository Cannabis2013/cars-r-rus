package dat3.car.members.dtos;

import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

@Getter
public class MemberAddRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Map<String,String> phones = new HashMap<>();

    private String email;
    private String street;
    private String city;
    private String zip;
}
