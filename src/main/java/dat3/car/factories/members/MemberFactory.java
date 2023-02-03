package dat3.car.factories.members;

import dat3.car.Entities.members.Member;
import dat3.car.dto.members.MemberDto;
import org.springframework.stereotype.Service;

@Service
public class MemberFactory {
    public MemberFactory() {
        this.converter = new MemberConverter();
    }

    public Member fromDto(MemberDto dto)
    {
        return converter._fromDto(dto);
    }

    public MemberDto toDto(Member member)
    {
        return converter._toDto(member);
    }

    private final MemberConverter converter;
}
