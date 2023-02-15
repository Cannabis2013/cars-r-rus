package dat3.car.dto.members;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Builder
public class MemberResponse {
    private String username;
    private String firstName;
    private String lastName;
    private Map<String,String> phones = new HashMap<>();

    private String email;
    private String street;
    private String city;
    private String zip;
}
