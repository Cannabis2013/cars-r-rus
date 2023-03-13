package dat3.car.members.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
@Builder
public class MemberResponse {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private Map<String,String> phones;

    private String email;
    private String street;
    private String city;
    private String zip;
}
