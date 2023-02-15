package dat3.car.dto.members;

import lombok.Getter;

import java.util.Map;

@Getter
public class MemberUpdateRequest {
    private String id;
    private String username;
    private Map<String,String> phones;
    private String email;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zip;
}
