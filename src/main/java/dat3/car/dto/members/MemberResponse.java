package dat3.car.dto.members;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public final class MemberResponse {
    private String username;
    private String email;
    private List<String> phones;
    private String street;
    private String zip;
    private String city;
}
