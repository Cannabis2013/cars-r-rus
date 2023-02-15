package dat3.car.api;


import dat3.car.dto.members.MemberAddRequest;
import dat3.car.dto.members.MemberContactUpdate;
import dat3.car.dto.members.MemberUpdateRequest;
import dat3.car.services.members.Members;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/members/")
public class MembersApi {
    public MembersApi(Members members) {
        this.members = members;
    }

    @GetMapping("/all")
    public ResponseEntity<String> members(){
        return members.all();
    }

    @GetMapping("/")
    public ResponseEntity<String> member(@RequestParam String id){
        return members.get(id);
    }

    @PostMapping("add")
    public ResponseEntity<String> addMember(@RequestBody MemberAddRequest request){
        return members.add(request);
    }

    @PostMapping("remove")
    public ResponseEntity<String> remove(@RequestParam String id)
    {
        return members.remove(id);
    }

    @PutMapping("update")
    public ResponseEntity<String> update(@RequestBody MemberUpdateRequest request)
    {
        return members.update(request);
    }

    private final Members members;
}
