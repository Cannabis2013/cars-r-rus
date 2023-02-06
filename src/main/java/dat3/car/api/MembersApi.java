package dat3.car.api;

import dat3.car.dto.members.MemberRequest;
import dat3.car.services.members.Members;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MembersApi {
    public MembersApi(Members members) {
        this.members = members;
    }

    @GetMapping("/members")
    public ResponseEntity<String> members(){
        return members.all();
    }

    @PostMapping("/members/add")
    public ResponseEntity<String> addMember(@RequestBody MemberRequest request){
        return members.add(request);
    }

    @PostMapping("/members/remove")
    public ResponseEntity<String> remove(@RequestParam String id)
    {
        return members.remove(id);
    }

    @PutMapping("/members/update")
    public ResponseEntity<String> update(@RequestBody MemberRequest request)
    {
        return members.update(request);
    }

    private final Members members;
}
