package dat3.car.factories.members;

import dat3.car.Entities.members.Member;
import dat3.car.dto.members.MemberDto;

class MemberConverter {
    Member _fromDto(MemberDto dto)
    {
        return new Member();
    }

    MemberDto _toDto(Member member)
    {
        var personalDetails = member.getPersonalDetails();
        var addressDetails = member.getAddressDetails();
        return null;
    }



}
