package dat3.car.api;

import dat3.car.Entities.members.Member;
import dat3.car.services.members.Members;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MembersApi {
    public MembersApi(Members members) {
        this.members = members;
    }

    @GetMapping("/members")
    public ResponseEntity<String> members(){
        return members.all();
    }

    public ResponseEntity<String> addMember(@RequestBody Member member){
        return members.add(member);
    }

    private final Members members;
}
