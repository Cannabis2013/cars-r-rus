package dat3.car.dto.members;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class MemberContactUpdate {
    private String id;
    private Map<String,String> phones;
    private String email;
}
