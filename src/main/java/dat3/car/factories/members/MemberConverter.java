package dat3.car.factories.members;

import dat3.car.Entities.members.AddressDetails;
import dat3.car.Entities.members.Member;
import dat3.car.Entities.members.PersonalDetails;
import dat3.car.dto.members.MemberRequest;
import dat3.car.dto.members.MemberResponse;

import java.util.Map;

class MemberConverter {
    Member fromRequest(MemberRequest request)
    {
        var member = new Member();
        member.setEmail(request.getEmail());
        member.setUsername(member.getUsername());
        return member;
    }

    MemberResponse toResponse(Member member)
    {
        return _toResponse(member);
    }

    private MemberResponse _toResponse(Member member)
    {
        var response = new MemberResponse();
        updateUserDetails(response, member);
        updateAddressDetails(response, member);
        return response;
    }

    private void updateUserDetails(MemberResponse dto, Member member)
    {
        member.setUsername(member.getUsername());
        dto.setEmail(member.getEmail());
    }

    private void updateUserDetails(MemberRequest request, Member member)
    {
        var personalDetails = new PersonalDetails(request.getFirstName(),request.getLastName());
        member.setPersonalDetails(personalDetails);
        request.setUsername(member.getUsername());
        request.setEmail(member.getEmail());
    }

    private void updateAddressDetails(MemberResponse response, Member member)
    {
        var phones = member.getAddressDetails().getPhones()
                .entrySet().stream().map(Map.Entry::getValue).toList();
        response.setPhones(phones);
        response.setStreet(member.getAddressDetails().getStreet());
        response.setCity(member.getAddressDetails().getCity());
        response.setZip(member.getAddressDetails().getZip());
    }

    private void updateAddressDetails(MemberRequest response, Member member)
    {
        var addressDetails = new AddressDetails(response.getStreet(),response.getCity(),response.getZip());

    }
}
