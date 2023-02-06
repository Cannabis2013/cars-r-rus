package dat3.car.dto.members;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
@Builder
public final class MemberRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private Map<String,String> phones;
    private String street;
    private String zip;
    private String city;
    private String memberId;
}
