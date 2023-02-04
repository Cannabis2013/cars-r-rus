package dat3.car.dto.members;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
public final class MemberDto {
    private String username;
    private String email;
    private Map<String,String> phone;
    private String street;
    private String zip;
    private String city;
}
