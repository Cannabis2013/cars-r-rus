package dat3.car.members.api;


import dat3.car.members.dtos.MemberAddRequest;
import dat3.car.members.dtos.MemberUpdateRequest;
import dat3.car.members.services.MemberManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/members/")
@CrossOrigin
public class MembersApi {
    public MembersApi(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @GetMapping("/user/all")
    public ResponseEntity<String> members(){
        return memberManager.all();
    }

    @GetMapping("/")
    public ResponseEntity<String> member(@RequestParam String id){
        return memberManager.get(id);
    }

    @PostMapping("add")
    public ResponseEntity<String> addMember(@RequestBody MemberAddRequest request){
        return memberManager.add(request);
    }

    @PostMapping("remove")
    public ResponseEntity<String> remove(@RequestParam String id)
    {
        return memberManager.remove(id);
    }

    @PutMapping("update")
    public ResponseEntity<String> update(@RequestBody MemberUpdateRequest request)
    {
        return memberManager.update(request);
    }

    private final MemberManager memberManager;
}
