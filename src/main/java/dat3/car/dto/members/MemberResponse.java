package dat3.car.dto.members;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public final class MemberResponse {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Map<String,String> phones;
    private String street;
    private String zip;
    private String city;
    private String memberId;
}
