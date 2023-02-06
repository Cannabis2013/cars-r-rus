package dat3.car.services.members;

import dat3.car.Entities.members.Member;
import dat3.car.SLA.Http.HttpResult;
import dat3.car.factories.members.MemberFactory;
import dat3.car.repository.MemberRepository;
import dat3.car.services.Entities.EntitiesConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Members {
    public Members(MemberFactory memberFactory, MemberRepository memberRepository, HttpResult<String> response) {
        this.memberFactory = memberFactory;
        this.memberRepository = memberRepository;
        this.entitiesConverter = new EntitiesConverter<>();
        this.response = response;
    }

    public ResponseEntity<String> all()
    {
        var ite = memberRepository.findAll();
        var members = entitiesConverter.toList(ite);
        var dtos = members.stream().map(memberFactory::toResponse).toList();
        return response.ok(dtos);
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

    private final MemberFactory memberFactory;
    private final MemberRepository memberRepository;
    private final EntitiesConverter<Member> entitiesConverter;
    private final HttpResult<String> response;
}
