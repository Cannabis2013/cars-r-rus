package dat3.car.factories.members;

import dat3.car.Entities.members.Member;
import dat3.car.dto.members.MemberDto;

class MemberConverter {
    Member fromDto(MemberDto dto)
    {
        return new Member();
    }

    MemberDto toDto(Member member)
    {
        return _toDto(member);
    }

    private MemberDto _toDto(Member member)
    {
        var dto = new MemberDto();
        addUserDetails(dto, member);
        addAdressDetails(dto, member);
        return dto;
    }

    private void addUserDetails(MemberDto dto, Member member)
    {
        dto.setUsername(member.getUsername());
        dto.setEmail(member.getEmail());
    }

    private void addAdressDetails(MemberDto dto, Member member)
    {
        dto.setPhone(member.getAddressDetails().getPhones());
        dto.setStreet(member.getAddressDetails().getStreet());
        dto.setCity(member.getAddressDetails().getCity());
        dto.setZip(member.getAddressDetails().getZip());
    }
}
