package dat3.car.factories.members;

import dat3.car.Entities.members.Member;
import dat3.car.dto.members.MemberRequest;
import dat3.car.dto.members.MemberResponse;
import org.springframework.stereotype.Service;

@Service
public class MemberFactory {
    public MemberFactory() {
        this.converter = new MemberConverter();
    }

    public Member fromRequest(MemberRequest dto)
    {
        return converter.fromRequest(dto);
    }

    public MemberResponse toResponse(Member member)
    {
        return converter.toResponse(member);
    }

    private final MemberConverter converter;
}
