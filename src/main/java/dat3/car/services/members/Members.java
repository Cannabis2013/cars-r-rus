package dat3.car.services.members;

import dat3.car.Entities.members.Member;
import dat3.car.SLA.Http.HttpResult;
import dat3.car.repository.MemberRepository;
import dat3.car.services.Entities.EntitiesConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Members {
    public ResponseEntity<String> all()
    {
        var ite = memberRepository.findAll();
        var members = entitiesConverter.toList(ite);
        return response.ok(members);
    }

    public ResponseEntity<String> get(String id)
    {
        return response.bad("Not implemented yet");
    }

    public ResponseEntity<String> remove(String id)
    {
        return response.bad("Not implemented yet");
    }

    public ResponseEntity<String> add(Member member)
    {
        try {
            memberRepository.save(member);
        } catch (Exception e){
            return response.bad(e.getMessage());
        }
        return response.created(member);
    }

    private MemberRepository memberRepository;
    private EntitiesConverter<Member> entitiesConverter;
    private HttpResult<String> response;
}
